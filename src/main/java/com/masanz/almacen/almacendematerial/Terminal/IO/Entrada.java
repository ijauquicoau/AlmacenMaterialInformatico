package com.masanz.almacen.almacendematerial.Terminal.IO;

import java.util.Scanner;

public class Entrada {//queda por revisar

    public static int LeerEntero(String s,int n1,int n2){
        Scanner teclado = new Scanner(System.in);
        int v = -1;
        while (v < n1 || v > n2) {
            System.out.printf("%s [%d-%d]: ", s, n1, n2);
            v = teclado.nextInt();
        }
        teclado.nextLine();
        return v;
    }

    public static double leerDecimalPositivo(String s){
        Scanner scanner = new Scanner(System.in);
        double valor;

        while (true) {
            try {
                System.out.print(s);
                valor = Double.parseDouble(scanner.nextLine());

                if (valor >= 0) {
                    return valor;
                } else {
                    System.out.println("El valor debe ser un número decimal positivo, inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un valor decimal válido.");
            }
        }
    }
    public static String leerString(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.print(s);
        return scanner.nextLine();
    }
}
