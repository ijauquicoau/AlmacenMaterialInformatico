package com.masanz.almacen.almacendematerial.Model;

import com.masanz.almacen.almacendematerial.Exceptions.ExcepcionAmi;

import java.time.LocalDate;
import java.util.*;

public class Armario {
    public static final int Filas = 5;
    public static final int Columnas = 4;
    public static final int Espacios_X_Celda = 4;
    private Celda[][] celdas = new Celda[Filas][Columnas];


    public Armario(){
        for (int i = 0; i < Filas; i++) {
            for (int j = 0; j < Columnas; j++) {
                celdas[i][j] = new Celda(Espacios_X_Celda);

            }

        }
    }
    public int getFilas(){
        return Filas;
    }

    public int getColumnas(){
        return Columnas;
    }
    public Celda getCelda(int f,int c){
        return celdas[f][c];

    }
    //obtienes el espacio libre de cada celda
    public int getEspacioLibre(Posicion p){
        int f = p.getFilaNumber()-1;
        int c = p.getColumna()-1;
        Celda ce = celdas[f][c];
        return ce.getEspacioLibre();
    }
    // metes una articulo con una posicion a traves de las filas y columnas
    public void meter(Posicion p, Articulo a) throws ExcepcionAmi {
        int f = p.getFilaNumber()-1;
        int c = p.getColumna()-1;
        Celda ce = celdas[f][c];

        ce.meter(a);

    }
    //obtienes lo ocupada que esté una celda
    public int getOcupacionCelda(Posicion p){
        int f = p.getFilaNumber()-1;
        int c = p.getColumna()-1;
        Celda ce = celdas[f][c];
        return ce.getEspacioOcupado();
    }
    //obtienes los articulos de cada celda del amrario
    public List<Articulo> getArticulos(int n1,int n2 ){// Las filas y columnas se enumeran desde el 1 por tanto se le resta 1
        int f = n1 -1;
        int c = n2 -1;
        Celda ce = celdas[f][c];
        return ce.getLista();

    }
    // buscas en el armario las posiciones de la celda que tengan espacio, para ello recorres cada celda con un bucle
    public Posicion buscarPosicionConEspacio(int b){
        for (int i = Filas -1; i >=0; i--) {
            for (int j = Columnas -1; j >= 0; j--) {
                if (celdas[i][j].getEspacioLibre()>= b){
                    return new Posicion(i +1,j+1);// le pongo +1 debido a que la posicion está en modo java que seria del 0 al 4 y yo lo quiero del 1 al 5 y si no me daria error
                }



            }

        }
        return null;
    }
    //obtienes la posicion del articulo en la celda del armario, para ello vuelves a recorrer el armario
    public Posicion getPosicionArticulo(Articulo a){
        for (int i = Filas -1; i >=0; i--) {
            for (int j = Columnas - 1; j >= 0; j--) {
                if (celdas[i][j].estaArticulo(a)){
                    return new Posicion(i+1,j+1);// le pongo +1 debido a que la posicion está en modo java que seria del 0 al 4 y yo lo quiero del 1 al 5 y si no me daria error

                }
            }
        }
        return null;
    }
    //compruebas si existe el id del articulo en el armario
    public boolean existeIdArticulo(String existe){
        for (int i = Filas -1; i >=0 ; i--) {
            for (int j = Columnas-1; j >=0 ; j--) {
                if (celdas[i][j].existeIdArticulo(existe)){
                    return true;
                }

            }

        }

        return false;

    }
//obtienes el articulo
    public Articulo getArticulo(String s){
        for (int i = Filas -1; i >=0 ; i--) {
            for (int j = Columnas-1; j >=0 ; j--) {
                Articulo a = celdas[i][j].getArticulo(s);
                if (a!= null){
                    return a;

                }

            }

        }
        return null;
    }
        //ordenas los articulos por los tipos
    public Map<ETipoArticulo,List<Articulo>> articulosPorTipo(java.util.Comparator<Articulo>comparador,EOrden orden ){
        ETipoArticulo[] tipos = ETipoArticulo.values();
        Map<ETipoArticulo,List<Articulo>> listado = new HashMap<>();
        for(ETipoArticulo tipo: ETipoArticulo.values()) {
            listado.put(tipo, new LinkedList<>());
        }
        for (int i = Filas -1 ; i >=0 ; i--) {
            for (int j = Columnas -1; j >=0 ; j--) {
                List<Articulo> lista =celdas[i][j].getLista();
                for (Articulo a : lista){
                    ETipoArticulo t = a.getTipo();
                    List<Articulo> l =  listado.get(t);
                    l.add(a);
                }

            }

        }

        for (ETipoArticulo et: tipos) {

            List<Articulo> lista =  listado.get(et);
            lista.sort(comparador);
            if (orden == EOrden.Descendente){
                List<Articulo> lista2 = new LinkedList<>();
                for (Articulo a: lista) {
                    lista2.add(0,a);
                }
                listado.put(et , lista2);
            }

        }

        return listado;
    }

    @Override
    public String toString() {//prueba del to string
        String s = "";
        String letras = "ABCDE";

        s +="   |                   1                   |                   2                   |                   3                   |                   4                   |\n";
        s+="--------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";

        for (int i = 0; i < Filas; i++) {
            s += " "+ letras.charAt(i)+ " |";

            for (int j = 0; j <Columnas ; j++) {
                Celda c = celdas[i][j];
                s+=  c.toString();

            }
            s += "\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";

        }
        return s;
    }

    //pruebas
    public static void main(String[] args)  {
        Armario armario = new Armario();

        LocalDate fecha = LocalDate.parse("2023-06-11");
        Posicion p = new Posicion(2,1);
        Articulo a = new Articulo("CPU1001",ETipoArticulo.CPU,2, fecha,25);
        Articulo a1 = new Articulo("CPU1002",ETipoArticulo.CPU,3, fecha,25);
        Articulo a2 = new Articulo("CPU1003",ETipoArticulo.CPU,5, fecha,25);
        Posicion p1 = new Posicion(4,2);
        try {
            armario.meter(p1,a2);
        }catch (ExcepcionAmi ea){
            System.out.println(ea.getMessage());
        }
        try {
            armario.meter(p,a);
        }catch (ExcepcionAmi ea){
            System.out.println(ea.getMessage());
        }
        System.out.println(armario);
    }
}





