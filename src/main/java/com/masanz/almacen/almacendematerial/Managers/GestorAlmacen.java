package com.masanz.almacen.almacendematerial.Managers;

import com.masanz.almacen.almacendematerial.Model.*;

import java.util.List;
import java.util.Map;

public class GestorAlmacen {

    private static final int ESPACIOS_CELDA = 4;
    private Armario armario;


    public GestorAlmacen(){

    }

    public Armario getArmario() {
        return armario;
    }
    public int getEspaciosCelda(){
        return ESPACIOS_CELDA;
    }
    public int getFilas(){
        return Armario.Filas ;
    }

    public int getColumnas(){
        return Armario.Columnas;
    }
    public boolean meterArticulo(Articulo a){
        return false;
    }

    public Posicion getPosicionArticulo(Articulo a){
        return null;
    }
    public List<Articulo> getArticulos(int n1, int n2){
        return null;
    }
    public int getOcupacionCelda(Posicion p){
        return 0;
    }
    public  boolean existeIdArticulo(String s){
        return false;
    }
    public String saveCSV(){
        return null;
    }

    public void loadCSV(String s){

    }
    public Articulo getArticulo(String s){
        return null;
    }
    public Map <ETipoArticulo, List<Articulo>> articulosPorTipoPrecio(EOrden tipo) {
        return null;
    }
    public Map <ETipoArticulo, List<Articulo>> articulosPorTipoFecha(EOrden tipo) {
        return null;
    }
}
