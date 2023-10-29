package com.masanz.almacen.almacendematerial.Terminal.Menus;

import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;

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
                System.out.println("=        Almacen de Material Informatico (AMI)");
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

            }
        }
    }

    private void mostrarArmario() {
        System.out.println(" |                  1                   |                  2                   |                  3                  |                  4                  |");
        System.out.println("  ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    private void meterArticulo() {

    }

    private void consultarArticulo() {

    }

    private void consultarCelda() {

    }

    private void menuListados() {

    }

    private void grabarEstado() {

    }

    private void cargaDatos() {

    }

    public static void main(String[] args) {
        GestorAlmacen gestor = new GestorAlmacen();
        MenuPrincipal menu = new MenuPrincipal(gestor);
        menu.run();
    }

}
