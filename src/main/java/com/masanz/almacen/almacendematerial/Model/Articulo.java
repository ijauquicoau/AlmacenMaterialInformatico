package com.masanz.almacen.almacendematerial.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Articulo {
    private String id;
    private ETipoArticulo tipo;
    private int espacio;
    private LocalDate fechaAdquisicion;
    private double precio;


    public Articulo(){

    }

    public Articulo(String A){


    }
    public Articulo(String Ar, ETipoArticulo e, int n,LocalDate lc,double d){
        this.id = Ar;
        this.tipo = e;
        this.espacio = n;
        this.fechaAdquisicion = lc;
        this.precio = d;

    }
    public boolean equals(Object o){
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, espacio, fechaAdquisicion, precio);
    }

    public String toString(){
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ETipoArticulo getTipo() {
        return tipo;
    }

    public void setTipo(ETipoArticulo tipo) {
        this.tipo = tipo;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }



}


