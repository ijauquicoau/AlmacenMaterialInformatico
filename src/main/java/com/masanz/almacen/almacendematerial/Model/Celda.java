package com.masanz.almacen.almacendematerial.Model;

import com.masanz.almacen.almacendematerial.Exceptions.ExcepcionAmi;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Celda {
    private int espacio;
    private List<Articulo> lista;

    public Celda(int c){
        this.espacio = c;
        this.lista = new LinkedList<>();
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

//mete el articulo, con excepciones de si ya esta el articulo o si no hay espacio en la celda correspondiente
    public void meter(Articulo a) throws ExcepcionAmi{

        if (estaArticulo(a)){
            throw new ExcepcionAmi("El articulo ya está en la lista");
        }else if (getEspacioLibre()< a.getEspacio()) {
            throw new ExcepcionAmi("No hay espacio suficiente en esta celda");
        }else {
            lista.add(a);
        }
    }
    //obtienes el espacio libre de la celda
    public int getEspacioLibre(){
        return this.espacio - getEspacioOcupado();
    }
    //obtienes el espacio ocupado de la celda
    public int getEspacioOcupado(){
        int espacioOcupado = 0;
        for (Articulo a: lista) {
            espacioOcupado += a.getEspacio();
        }
        return espacioOcupado;
    }
    //comprueba si está el articulo
    public boolean estaArticulo(Articulo a){

        return lista.contains(a);
    }
    public boolean existeIdArticulo(String id){
        return getArticulo(id) != null;
    }
    public Articulo getArticulo(String id){
        for (Articulo a: lista) {
            if (a.getId().equals(id))
                return a;
        }
        return null;
    }
    public Iterator<Articulo> iterator(){

        return lista.iterator();
    }

    @Override
    public String toString() {//prueba del tostirng
        String s =  "";
        if (lista.isEmpty()){
            return "                                       |";
        }
        for (Articulo a:lista) {
            int espacio = a.getEspacio();
            if (espacio == 1){
                s +=  "_"+ a.getId() +"_|";
            }else if (espacio == 2){
                s += "______" + a.getId() + "______|";
            }else if (espacio == 3){
                s += "___________"+ a.getId() +"___________|";
            }else{
                s += "________________" +a.getId() + "________________|";
            }
        }
        int espacioLibre = getEspacioLibre();
        if (espacioLibre == 1 ){
            s += "         |";
        }else if (espacioLibre == 2){
            s += "         |         |";
        }else{
            s += "         |         |         |";
        }
        return s;
    }

    public static void main(String[] args) {//pruebas
        Celda micelda = new Celda(4);
        LocalDate fecha = LocalDate.parse("2023-06-11");
        Articulo a = new Articulo("CPU1001",ETipoArticulo.CPU,2, fecha,25);
        Articulo ar = new Articulo("CPU1002",ETipoArticulo.CPU,2, fecha,25);
        Articulo ar1 = new Articulo("CPU1003",ETipoArticulo.CPU,2, fecha,25);
        Articulo ar2= new Articulo("CPU1004",ETipoArticulo.CPU,2, fecha,25);
        Articulo ar3= new Articulo("CPU1005",ETipoArticulo.CPU,2, fecha,25);
        try {
            micelda.meter(a);
            micelda.meter(a);

        }catch (ExcepcionAmi ea){
            System.out.println(ea.getMessage());
        }try {
            micelda.meter(ar1);
            micelda.meter(ar2);

        }catch (ExcepcionAmi ea){
            System.out.println(ea.getMessage());
        }

    }
}
