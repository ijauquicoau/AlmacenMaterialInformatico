package com.masanz.almacen.almacendematerial.Terminal.Menus;

import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;

public class MenuPrincipal {

    private GestorAlmacen gestorAlmacen;


    public MenuPrincipal(GestorAlmacen gestor) {
        gestorAlmacen = gestor;
    }

    private void cargaInicialDatos() {
        //todo
    }

    public void run() {
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
        System.out.println("Opcion [0-7]:");
    }

    private void mostrarArmario() {

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
