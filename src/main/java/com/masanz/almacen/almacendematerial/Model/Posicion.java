package com.masanz.almacen.almacendematerial.Model;

import javafx.geometry.Pos;

public class Posicion {
    private static  String letras = "abcde";
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
        return 0;
    }
    public int getFilaNumber(){
        return 0;
    }
    public void setFila(char f){

    }
    public void setFilaNumber(int fn){

    }
    public void setFilaColumnaNumbers(int f,int c){

    }
    public static String getLetras(){
        return letras;
    }
    public int getColumna(){
        return 0;
    }
    private int filaToInt(char f){
        return 0;
    }
    private char filaToChar(int f){
        return 0;
    }

    public boolean equals(Object o){
        return false;
    }

    public String toString(){
        return null;
    }
    public int compareTo(Posicion p){
        return 0;
    }
}


