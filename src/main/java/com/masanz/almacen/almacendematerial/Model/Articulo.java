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
    public Articulo(String id, ETipoArticulo tipo, int espacio,LocalDate lc,double precio){
        this.id = id;
        this.tipo = tipo;
        this.espacio = espacio;
        this.fechaAdquisicion = lc;
        this.precio = precio;

    }
    //comprueba si los articulos son iguales o no
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
        Articulo ar = new Articulo("CPU1002",ETipoArticulo.CPU,2, fecha,25);
        System.out.println(a.id);
        System.out.println(a.equals(ar));

    }
}


