package com.masanz.almacen.almacendematerial.Model;

import com.masanz.almacen.almacendematerial.Exceptions.ExcepcionAmi;
import javafx.geometry.Pos;

import java.time.LocalDate;
import java.util.Locale;

public class Posicion {
    private static final String letras = "abcde"; //letra de la "a" a la "e" del 1 al 5 y columnas igual, del 1 al 5
    private char fila;
    private int columna;

    public Posicion() {

    }
    public Posicion(char letra,int n){
        this.columna = n;
        this.fila = letra;

    }
    public Posicion(int f,int c){
        this.fila = letras.charAt(f-1);
        this.columna = c;
    }
    public Posicion(String p){ // c3
        this.fila = p.charAt(0);
        this.columna =Integer.parseInt(""+p.charAt(1));
    }
    public char getFila(){
        return fila;
    }
    public int getFilaNumber(){
        return filaToInt(fila);
    }
    public void setFila(char f){
        this.fila = f;

    }
    //convierte la fila ej.(A) a un numero(0)
    public void setFilaNumber(int fn){
        fila = letras.charAt(fn -1);

    }
    public void setFilaColumnaNumbers(int f,int c){
        setFilaNumber(f);
        setColumna(c);

    }
    public static String getLetras(){
        return letras ;
    }
    public int getColumna(){
        return columna;
    }
    public void setColumna(int i){
        columna=i;
    }
    private int filaToInt(char f){
        char c = Character.toLowerCase(f);
        return letras.indexOf(""+c)+1;

    }
    private char filaToChar(int f){
        return letras.charAt(f -1);
    }

    //comprueba si la posicion es la misma
    public boolean equals(Object o){
        Posicion p = (Posicion) o;
        if (p.fila == fila && p.columna == columna){
            return true;
        }
        return false;
    }
    public int hashCode(){
        return filaToInt(fila)*10 + columna  ;
    }
    public String toString(){

        return ""+fila + columna;
    }
    public int compareTo(Posicion p){
        return p.hashCode()-hashCode();
    }

    public static void main(String[] args) throws ExcepcionAmi {
        LocalDate fecha = LocalDate.parse("2023-06-11");
        Posicion p = new Posicion(2,1);
        Articulo a = new Articulo("CPU1001",ETipoArticulo.CPU,2, fecha,25);
        Armario armario = new Armario();
        armario.meter(p,a);
    }
}


