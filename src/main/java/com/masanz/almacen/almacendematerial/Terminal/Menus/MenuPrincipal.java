package com.masanz.almacen.almacendematerial.Terminal.Menus;

import com.masanz.almacen.almacendematerial.Exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.IO.CsvLoader;
import com.masanz.almacen.almacendematerial.IO.CsvSaver;
import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.Model.Armario;
import com.masanz.almacen.almacendematerial.Model.Articulo;
import com.masanz.almacen.almacendematerial.Model.ETipoArticulo;
import com.masanz.almacen.almacendematerial.Model.Posicion;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private GestorAlmacen gestorAlmacen;


    public MenuPrincipal(GestorAlmacen gestor) {
        gestorAlmacen = gestor;
    }

    private void cargaInicialDatos() {
        //todo
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int numero = -1;
        while (numero != 0) {


            while (numero < 0 || numero > 7) {
                System.out.println("===========================================================");
                System.out.println("=        Almacen de Material Informatico (AMI)            =");
                System.out.println("===========================================================");
                System.out.println("    1. Mostrat armario del almacén");
                System.out.println("    2. Meter articulo en armario");
                System.out.println("    3. Consultar articulo");
                System.out.println("    4. Consultar celda");
                System.out.println("    5. Listados (menu)");
                System.out.println("    6. Grabar estado");
                System.out.println("    7. Cargar datos");
                System.out.println("    0. Terminar");
                System.out.println("==================================");
                System.out.print("Opcion [0-7]:");

                numero = scanner.nextInt();
                if (numero < 0 || numero > 7) {
                    System.out.println("La opcion que has puesto es incorrecta, meta un numero del 0 al 7");
                }
            }


            if (numero == 1) {
                mostrarArmario();
            } else if (numero == 2) {
                meterArticulo();

            } else if (numero == 3) {
                consultarArticulo();

            } else if (numero == 4) {
                consultarCelda();

            } else if (numero == 5) {
                menuListados();

            } else if (numero == 6) {
                grabarEstado();

            } else if(numero == 7){
                cargaDatos();

            } else {
                break;
            }
            numero = -1;
        }
    }
// muestras el armario
    private void mostrarArmario() {
        Armario a = gestorAlmacen.getArmario();
        System.out.println(a);
    }
//metes el articulo con cada categoria y en orden, si no lo pones bien, en la categoria donde hayas puesto algo mal te saldra un error y te pondra para intentar de nuevo
    private void meterArticulo() {
        String id = "";
        double precio = -1;
        int espacio = -1;
        ETipoArticulo tipo = null;
        LocalDate fecha = null;
        Scanner scanner = new Scanner(System.in);
        while (id.length()!= 7){
            System.out.print("Id del articulo (7 caracteres), ej. MON0001: ");
            id = scanner.next();
            if (id.length()!= 7){
                System.out.println("El ID tiene que tener 7 caracteres, inténtelo de nuevo");
            }
        }

        while (tipo == null){
            System.out.print("tipo del articulo (Monitor,CPU,Impresora,Fax,Scanner)");
            try {
                tipo = ETipoArticulo.valueOf(scanner.next());
            } catch (IllegalArgumentException e) {
                System.out.println("Ese tipo no existe, inténtelo de nuevo");
            }
        }
        while (precio < 0  ){
            System.out.print("Precio, ej. 1500.00: ");
            try{
                String precioStr = scanner.next();
                precio = Double.parseDouble(precioStr);
            }catch (Exception e ){
                System.out.println("No ha puesto el precio bien, inténtelo de nuevo"+ e.getMessage());
            }
        }
        while (fecha == null) {
            System.out.print("fecha, ej. 2002-12-09: ");
            try {
                fecha = LocalDate.parse(scanner.next());
            } catch (IllegalArgumentException e) {
                System.out.println("No ha puesto la fecha en el formato indicado, inténtelo de nuevo");
            }
        }

        while (espacio<1 || espacio>4){
            System.out.print("El espacio debe estar entre el 1 y el 4, ej. 1: ");
            try {
                espacio = Integer.parseInt(scanner.next());
            }catch (IllegalArgumentException e){
                System.out.println("No ha puesto un espacio dentro del rango anterios, inténtelo de nuevo");
            }
        }
        Articulo a = new Articulo(id, tipo, espacio, fecha, precio);
        try {
            gestorAlmacen.meterArticulo(a);
        }catch(ExcepcionAmi e) {
            System.out.println(e.getMessage());
        }

    }
    //consultas el articulo que hay en el armario, el cual te devuelve cada una de sus caracterisiticas(tipo,precio...)

    private void consultarArticulo() {
        Scanner scanner= new Scanner(System.in);

        System.out.print("Id del articulo (7 caracteres), ej. IMP0001: ");

        String id= scanner.next();

        Articulo a= gestorAlmacen.getArticulo(id);
        if (a==null){
            System.out.println("No se ha encontrado el Id correspondiente");
        }else{
            System.out.println("\n      Id: "+ id);
            System.out.println("    Tipo: " + a.getTipo().toString());
            System.out.println(" Espacio: " + a.getEspacio());
            System.out.println("   Fecha: " + a.getFechaAdquisicion());
            System.out.println("  Precio: " + a.getPrecio());
            System.out.println("Posicion: " + gestorAlmacen.getPosicionArticulo(a));
        }
    }

    private void consultarCelda() {
        //consultar cada celda donde se muestra el tipo y por cada tipo los objetos que hay en cada tipo
        Scanner scanner = new Scanner(System.in);
        System.out.println("Celda, ej. A1,B4");
        String celda = scanner.next();

        Posicion p = new Posicion(celda);
        List<Articulo> lista = gestorAlmacen.getArticulos(p.getFilaNumber(),p.getColumna());

                for (int i = 0; i < lista.size(); i++) {
                    Articulo a = lista.get(i);
                    if (a.getEspacio() == 1) {
                        System.out.println("| " + a.getId() + "    |");
                    } else if (a.getEspacio() == 2) {
                        System.out.println("|        " + a.getId() + "        |");
                    } else if (a.getEspacio() == 3) {
                        System.out.println("|               " + a.getId() + "               |");
                    } else if (a.getEspacio() == 4) {
                        System.out.println("|                      " + a.getId() + "                      |");

                    }
                }




                for (int i = 0; i < lista.size(); i++) {
                    Articulo a = lista.get(i);
                    if (a.getEspacio() == 1) {
                        System.out.println(String.format("|         %8s", a.getTipo().toString()) + "           ");
                    } else if (a.getEspacio() == 2) {
                        System.out.println(String.format("|         %8s", a.getTipo().toString()) + "                 ");
                    } else if (a.getEspacio() == 3) {
                        System.out.println(String.format("|         %8s", a.getTipo().toString()) + "         ");
                    } else if (a.getEspacio() == 4) {
                        System.out.println(String.format("|         %8s", a.getTipo().toString()) + "           ");
                    }
                }


                // Fechas
                for (int i = 0; i < lista.size(); i++) {
                    Articulo a = lista.get(i);
                    if (a.getEspacio() == 1) {
                        System.out.println("| " + a.getFechaAdquisicion() + "    |");
                    } else if (a.getEspacio() == 2) {
                        System.out.println("|        " + a.getFechaAdquisicion() + "        |");
                    } else if (a.getEspacio() == 3) {
                        System.out.println("|               " + a.getFechaAdquisicion() + "               |");
                    } else if (a.getEspacio() == 4) {
                        System.out.println("|                      " + a.getFechaAdquisicion() + "                      |");

                    }
                }



                for (int i = 0; i < lista.size(); i++) {
                    Articulo a = lista.get(i);
                    if (a.getEspacio() == 1) {
                        System.out.println(String.format("|         %8s", a.getPrecio()) + "           ");
                    } else if (a.getEspacio() == 2) {
                        System.out.println(String.format("|         %8s", a.getPrecio()) + "                 ");
                    } else if (a.getEspacio() == 3) {
                        System.out.println(String.format("|         %8s", a.getPrecio()) + "         ");
                    } else if (a.getEspacio() == 4) {
                        System.out.println(String.format("|         %8s", a.getPrecio()) + "           ");
                    }
                }
            }


    private void menuListados() {
        MenuListados menu = new MenuListados(gestorAlmacen);
        menu.run();

    }
    // guardar el csv
    private void grabarEstado() {
        try {
            String archivo = CsvSaver.guardarCSV(gestorAlmacen);
            System.out.println("Estado del armario grabado correctamente");
            System.out.println(archivo);
        } catch (ExcepcionAmi e) {
            System.out.println(e.getMessage());
        }
    }
// carga el csv correspondiente
    private void cargaDatos() {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Introduce el nombre del fichero ej. backup/ami_2023-06-05_193120.csv :");
            String s= scanner.nextLine();
            CsvLoader.cargar(s,gestorAlmacen.getArmario());//repasar

        } catch (Exception e){
            System.out.println("Archivo seleccionado no grabado");
        }
    }

    public static void main(String[] args) {
        GestorAlmacen gestor = new GestorAlmacen();
        MenuPrincipal menu = new MenuPrincipal(gestor);
        menu.run();
    }

}
