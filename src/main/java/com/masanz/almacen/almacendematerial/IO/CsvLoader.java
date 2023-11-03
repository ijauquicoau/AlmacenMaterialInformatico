package com.masanz.almacen.almacendematerial.IO;

import com.masanz.almacen.almacendematerial.Exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.Model.Armario;
import com.masanz.almacen.almacendematerial.Model.Articulo;
import com.masanz.almacen.almacendematerial.Model.ETipoArticulo;
import com.masanz.almacen.almacendematerial.Model.Posicion;
import javafx.geometry.Pos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CsvLoader {

    public static void cargar(String archivoCSV, Armario a) throws ExcepcionAmi {

        try (Scanner scanner = new Scanner(new File(archivoCSV))) {
            scanner.useDelimiter(Pattern.compile("[;\n]"));
            while (scanner.hasNext()) {
                String posicion = scanner.next();
                String tipo = scanner.next();
                String id = scanner.next();
                String espacioOcupado = scanner.next();
                String fechaAdquisicion = scanner.next();
                String precio = scanner.next();
                scanner.next();//hago esto ya que hay una columna vacia ya que acaba la linea en ";" y entonces estaria cogiendo la posicion del siguiente articulo como ";"

                int espacio = Integer.parseInt(espacioOcupado);
                double precio2 = Double.parseDouble(precio);
                LocalDate fecha = LocalDate.parse(fechaAdquisicion);
                ETipoArticulo tipo2 = ETipoArticulo.valueOf(tipo);
                Posicion p = new Posicion(posicion);
                Articulo ar = new Articulo(id, tipo2,espacio,fecha,precio2);
                a.meter(p,ar);
            }
        } catch (IOException e) {
            throw new ExcepcionAmi(e.getMessage());
        }
    }

}
