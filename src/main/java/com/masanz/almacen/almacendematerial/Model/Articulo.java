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

    public Articulo(String id){
    this.id = id;

    }
    public Articulo(String Ar, ETipoArticulo e, int n,LocalDate lc,double d){
        this.id = Ar;
        this.tipo = e;
        this.espacio = n;
        this.fechaAdquisicion = lc;
        this.precio = d;

    }
    public boolean equals(Object o){
        if (!(o instanceof Articulo)){
            return false;
        }
        Articulo a = (Articulo) o;
        if (a.id == id){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, espacio, fechaAdquisicion, precio);
    }

    public String toString(){

             return  "      Id: "+ id+
                     "\n    Tipo: "+ tipo+
                     "\n Espacio: "+ espacio+
                     "\n   Fecha: "+ fechaAdquisicion+
                     "\n  Precio: "+precio;
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


    public static void main(String[] args) {
        LocalDate fecha = LocalDate.parse("2023-06-11");
        Articulo a = new Articulo("CPU1001",ETipoArticulo.CPU,2, fecha,25);
        System.out.println(a);
    }
}


