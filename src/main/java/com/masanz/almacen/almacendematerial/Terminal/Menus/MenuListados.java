package com.masanz.almacen.almacendematerial.Terminal.Menus;

import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.Model.Articulo;
import com.masanz.almacen.almacendematerial.Model.EOrden;
import com.masanz.almacen.almacendematerial.Model.ETipoArticulo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuListados {
    private GestorAlmacen gestorAlmacen;

    public void MenuListados(GestorAlmacen ga){

    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int numero = -1;
        while (numero != 0) {


            while (numero == 5) {
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

            }
            numero = -1;
        }
    }

    private void articuloPorTipoPrecio(){
        Scanner scanner = new Scanner(System.in);

        String orden = "";
        System.out.println("Por defecto orden Ascendente 'A' y orden Descendente 'D': ");
        orden = scanner.nextLine();
        Map<ETipoArticulo, List<Articulo>> lista;

        if (orden == "A" || orden == "D") {
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
        System.out.println("Por defecto orden Ascendente A u orden Descendente D: ");
        orden = scanner.nextLine();
        Map<ETipoArticulo, List<Articulo>> lista;

        if (orden == "A" || orden == "D") {
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

    }
     public static void main(String[] args) {

    }
}
