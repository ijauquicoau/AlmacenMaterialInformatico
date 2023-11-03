package com.masanz.almacen.almacendematerial.Managers;

import com.masanz.almacen.almacendematerial.Exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.IO.CsvLoader;
import com.masanz.almacen.almacendematerial.Model.*;
import javafx.geometry.Pos;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.masanz.almacen.almacendematerial.Model.Armario.Columnas;
import static com.masanz.almacen.almacendematerial.Model.Armario.Filas;

public class GestorAlmacen {

    private static final int ESPACIOS_CELDA = 4;
    private Armario armario = new Armario();


    public GestorAlmacen() {

    }

    public Armario getArmario() {
        return armario;
    }

    public int getEspaciosCelda() {
        return ESPACIOS_CELDA;
    }

    public int getFilas() {
        return Filas;
    }

    public int getColumnas() {
        return Columnas;
    }

    public boolean meterArticulo(Articulo a) throws ExcepcionAmi {
        Posicion p = armario.buscarPosicionConEspacio(a.getEspacio());
        if (p != null) {
            armario.meter(p, a);
            return true;
        }
        return false;
    }

    public Posicion getPosicionArticulo(Articulo a) {
        return armario.getPosicionArticulo(a);//revisar
    }

    public List<Articulo> getArticulos(int n1, int n2) {
        return armario.getArticulos(n1, n2);//revisar
    }

    public int getOcupacionCelda(Posicion p) {
        return armario.getOcupacionCelda(p);
    }

    public boolean existeIdArticulo(String s) {
        return armario.existeIdArticulo(s);

    }

    public String saveCSV()throws ExcepcionAmi {
        String nombreArchivo = System.getProperty("user.dir")+ "\\backup\\ami_"+  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss"))+ ".csv";
        try {


            PrintWriter archivo = new PrintWriter(nombreArchivo);
            for (int i = 1; i <= Filas; i++) {
                for (int j = 1; j <= Columnas; j++) {
                    List<Articulo> listaArticulo = armario.getArticulos(i, j);
                    for (Articulo a : listaArticulo) {
                        Posicion p = new Posicion(i, j);
                        archivo.println(p.toString() + ";" + a.getTipo() + ";" + a.getId() + ";" + a.getEspacio() + ";" + a.getFechaAdquisicion() + ";" + a.getPrecio() + ";");
                    }

                }

            }
            archivo.close();
        }catch (FileNotFoundException e){
            throw new ExcepcionAmi(e.getMessage());
        }
        return nombreArchivo;
    }

    public void loadCSV(String s) throws ExcepcionAmi {
        CsvLoader.cargar(s, armario);
    }

    public Articulo getArticulo(String s) {
        return armario.getArticulo(s);
    }

    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoPrecio(EOrden orden) {

        return armario.articulosPorTipo((o1, o2) ->(int)(o1.getPrecio() - o2.getPrecio()),orden);

    }


    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoFecha(EOrden orden) {

        return armario.articulosPorTipo((o1, o2) -> o1.getFechaAdquisicion().compareTo(o2.getFechaAdquisicion()),orden);
    }


}
