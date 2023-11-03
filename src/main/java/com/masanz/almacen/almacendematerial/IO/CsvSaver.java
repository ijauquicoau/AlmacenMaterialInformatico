package com.masanz.almacen.almacendematerial.IO;

import com.masanz.almacen.almacendematerial.Exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.Managers.GestorAlmacen;

import java.io.FileNotFoundException;

public  class CsvSaver {
    public static String guardarCSV(GestorAlmacen ga) throws ExcepcionAmi {
        return ga.saveCSV();
    }


}
