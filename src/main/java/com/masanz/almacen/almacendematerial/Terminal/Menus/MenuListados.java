package com.masanz.almacen.almacendematerial.Terminal.Menus;

import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.Model.Armario;
import com.masanz.almacen.almacendematerial.Model.Articulo;
import com.masanz.almacen.almacendematerial.Model.EOrden;
import com.masanz.almacen.almacendematerial.Model.ETipoArticulo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuListados {
    private GestorAlmacen gestorAlmacen;

    public MenuListados(GestorAlmacen ga){
        gestorAlmacen=ga;
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int numero = -1;
        while (numero != 0) {


            while (numero < 0 || numero > 3) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("-                  Listados    ( A M I )                  -");
                System.out.println("-----------------------------------------------------------");
                System.out.println("        1. Articulos por tipo y precio");
                System.out.println("        2. Articulos por tipo y fecha");
                System.out.println("        3. Importar articulos por tipo");
                System.out.println("        0. Terminar");
                System.out.println("-----------------------------------------------------------");
                System.out.print("Opcion [0-3]:");

                numero = scanner.nextInt();
                if (numero < 0 || numero > 3) {
                    System.out.println("La opcion que has puesto es incorrecta, meta un numero del 0 al 3");
                }
            }


            if (numero == 1) {
                articuloPorTipoPrecio();

            } else if (numero == 2) {
                articuloPorTipoFecha();

            } else if (numero == 3) {
                importePorTipos();

            } else {
                break;
            }
            numero = -1;
        }
    }

    private void articuloPorTipoPrecio(){
        Scanner scanner = new Scanner(System.in);

        String orden = "";
        System.out.println("Por defecto orden Ascendente 'A' o Descendente 'D': ");
        orden = scanner.nextLine();
        Map<ETipoArticulo, List<Articulo>> lista;

        if (orden.equals("A") || orden.equals("D") ) {
            lista = gestorAlmacen.articulosPorTipoPrecio(EOrden.Descendente);
        } else {
            lista = gestorAlmacen.articulosPorTipoPrecio(EOrden.Ascendente);
        }
        for (ETipoArticulo tipo : lista.keySet()) {
            List<Articulo> list = lista.get(tipo);
            System.out.println(tipo.toString());
            for (Articulo articulo : list) {
                System.out.println("                " + articulo.getId()+"      " +articulo.getFechaAdquisicion()+"     "+articulo.getPrecio());

            }

        }

    }
    private void articuloPorTipoFecha(){
        Scanner scanner = new Scanner(System.in);

        String orden = "";
        System.out.println("Por defecto orden Ascendente 'A' o Descendente 'D': ");
        orden = scanner.nextLine();
        Map<ETipoArticulo, List<Articulo>> lista;

        if (orden.equals("A")  || orden.equals("D") ) {
            lista = gestorAlmacen.articulosPorTipoFecha(EOrden.Descendente);
        } else {
            lista = gestorAlmacen.articulosPorTipoFecha(EOrden.Ascendente);
        }
        for (ETipoArticulo tipo : lista.keySet()) {
            List<Articulo> list = lista.get(tipo);
            System.out.println(tipo.toString());
            for (Articulo articulo : list) {
                System.out.println("                " + articulo.getId()+"      " +articulo.getFechaAdquisicion()+"     "+articulo.getPrecio());

            }

        }

    }
    private void importePorTipos(){
        Map<ETipoArticulo, List<Articulo>> lista = gestorAlmacen.articulosPorTipoPrecio(EOrden.Descendente);
            Double total = 0.0;
            Double d = 0.0;
          List<Articulo> ar =  lista.get(ETipoArticulo.Monitor);
        for (Articulo a: ar) {
            d += a.getPrecio();
            total += a.getPrecio();
        }
        System.out.println(String.format("%-15s%5.2f", ETipoArticulo.Monitor.toString(), d));
        d = 0.0;
        List<Articulo> ar1 =  lista.get(ETipoArticulo.Fax);
        for (Articulo a: ar1) {
            d += a.getPrecio();
            total += a.getPrecio();
        }
        System.out.println(String.format("%-15s%5.2f", ETipoArticulo.Fax.toString(), d));
        d = 0.0;
        List<Articulo> ar2 =  lista.get(ETipoArticulo.Impresora);
        for (Articulo a: ar2) {
            d += a.getPrecio();
            total += a.getPrecio();
        }
        System.out.println(String.format("%-15s%5.2f", ETipoArticulo.Impresora.toString(), d));
        d = 0.0;
        List<Articulo> ar3 =  lista.get(ETipoArticulo.Scanner);
        for (Articulo a: ar3) {
            d += a.getPrecio();
            total += a.getPrecio();
        }
        System.out.println(String.format("%-15s%5.2f", ETipoArticulo.Scanner.toString(), d));
        d = 0.0;
        List<Articulo> ar4 =  lista.get(ETipoArticulo.CPU);
        for (Articulo a: ar4) {
            d += a.getPrecio();
            total += a.getPrecio();
        }
        System.out.println(String.format("%-15s%5.2f", ETipoArticulo.CPU.toString(), d));;
        System.out.println("--------------------");
        System.out.println(String.format("%-15s%5.2f", "Total", total));

   }

     public static void main(String[] args) {

    }
}
