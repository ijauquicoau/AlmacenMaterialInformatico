package com.masanz.almacen.almacendematerial.Model;

import javafx.geometry.Pos;

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
        return letras.indexOf(""+f)+1;
    }
    private char filaToChar(int f){
        return letras.charAt(f -1);
    }

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

        return ""+letras + columna;
    }
    public int compareTo(Posicion p){
        return p.hashCode()-hashCode();
    }
}


