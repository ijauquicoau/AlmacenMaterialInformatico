package com.masanz.almacen.almacendematerial.Model;

import java.util.Iterator;
import java.util.List;

public class Celda {
    private int espacio;
    private List<Articulo> lista;

    public Celda(int c){

    }
    public List<Articulo>getLista(){
        return lista;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public void setLista(List<Articulo> lista) {
        this.lista = lista;
    }
    public void meter(Articulo a){

    }
    public int getEspacioLibre(){
        return 0;
    }
    public int getEspacioOcupado(){
        return 0;
    }
    public boolean estaArticulo(Articulo a){
        return false;
    }
    public boolean existeIdArticulo(String s){
        return false;
    }
    public Articulo getArticulo(String s){
        return null;
    }
    public Iterator<Articulo> iterator(){
        return null;
    }
}
