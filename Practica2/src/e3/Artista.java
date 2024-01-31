package e3;

import java.util.ArrayList;
import java.util.Date;

public class Artista implements Comparable<Artista>{
    String id;
    String nombre;
    Date fechaInicio;
    ArrayList<Integer> puntuaciones;
    ArrayList<String> generos;
    public Artista(String id,String nombre, Date fechaInicio, ArrayList<Integer> puntuaciones, ArrayList<String> generos) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.puntuaciones = puntuaciones;
        this.generos = generos;
    }
    public String getNombre() {
        return nombre;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public ArrayList<Integer> getPuntuaciones() {
        return puntuaciones;
    }
    public ArrayList<String> getGeneros() {
        return generos;
    }
    @Override
    public int compareTo(Artista o) {
        return id.compareTo(o.id);
    }
}
