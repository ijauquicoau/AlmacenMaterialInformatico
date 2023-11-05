package com.masanz.almacen.almacendematerial.Terminal.IO;

import java.util.Scanner;

public class Entrada {

    public static int LeerEntero(String s,int n1,int n2){
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.println(s);
            while (!scanner.hasNextInt()) {
                System.out.println("Introduce un número entero válido.");
                scanner.next();
            }
            numero = scanner.nextInt();
        } while (numero < n1 || numero > n2);

        return numero;
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
