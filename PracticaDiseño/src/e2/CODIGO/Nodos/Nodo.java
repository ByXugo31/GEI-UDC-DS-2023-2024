package e2.CODIGO.Nodos;

import e2.CODIGO.Flota;

import java.util.ArrayList;

public abstract class Nodo implements NodoOperaciones{
    String nombre;
    String tipo;
    protected ArrayList<Nodo> nodosHijos;

    public Nodo(String nombre, String tipo) {
        this.tipo = tipo;
        this.nombre = nombre;
        nodosHijos = new ArrayList<>();
    }

    protected void addHijos(Nodo n) {
        if(nodosHijos.size()>2) System.out.println("No se pueden añadir más nodos.");
        else nodosHijos.add(n);
    }

    public String getNombre(){
        return nombre;
    }
    public String getTipo(){return tipo;}
}
