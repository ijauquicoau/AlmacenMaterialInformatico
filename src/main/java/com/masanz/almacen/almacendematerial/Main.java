package com.masanz.almacen.almacendematerial;

import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.Terminal.Menus.MenuPrincipal;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal(new GestorAlmacen());
        menu.run();
    }
}
