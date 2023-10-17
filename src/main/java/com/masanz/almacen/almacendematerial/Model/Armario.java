package com.masanz.almacen.almacendematerial.Model;

import java.util.List;
import java.util.Map;

public class Armario {
    public static final int Filas = 5;
    public static final int Columnas = 4;
    public static final int Espacios_X_Celda = 4;
    private Celda[][] celdas;

public Armario(){
    this.celdas = new Celda[Filas][Columnas];
}
public int getFilas(){
    return 0;
}

public int getColumnas(){
    return 0;
}
public Celda getCelda(int f,int c){
    return null;

}
public int getEspacioLibre(Posicion p){
    return 0;
}
public void meter(Posicion p, Articulo a){

}
public int getOcupacionCelda(Posicion p){
    return 0;
}
public List<Articulo> getArticulos(int n1,int n2 ){
    return null;

}
public Posicion buscarPosicionConEspacio(int b){
    return null;
}
public Posicion getPosicionArticulo(Articulo a){
    return null;
}public boolean existeIdArticulo(String existe){
    return false;

}
public Articulo getArticulo(String get){
    return null;
}
public Map<ETipoArticulo,List<Articulo>> articulosPorTipo(java.util.Comparator<Articulo>comparador,EOrden orden ){
    return null;
}



}


