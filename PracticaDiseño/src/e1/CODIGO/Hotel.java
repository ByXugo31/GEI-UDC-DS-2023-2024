package e1.CODIGO;


import e1.CODIGO.Habitacion.Estado.Aprobada;
import e1.CODIGO.Habitacion.Estado.Limpia;
import e1.CODIGO.Habitacion.Estado.Ocupada;
import e1.CODIGO.Habitacion.Estado.PendienteLimpieza;
import e1.CODIGO.Habitacion.Habitacion;

import java.util.ArrayList;

public class Hotel {
    private String nombre;
    private ArrayList<Habitacion> habitaciones;

    public Hotel(String nombre) {
        this.habitaciones = new ArrayList<>();
        this.nombre=nombre;
    }

    public void addHabitacion(String supervisor){
        Habitacion h = new Habitacion(supervisor,habitaciones.size()+1);
        habitaciones.add(h);
    }

    public Habitacion getHabitacion(int habitacionId){
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                return h;
            }
        }
        System.out.println("Habitación no encontrada.");
        return null;
    }

    public void reservarHabitacion(int habitacionId, String nombreHuesped) {
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                h.reservarHabitacion(nombreHuesped);
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void liberarHabitacion(int habitacionId) {
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                h.liberarHabitacion();
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void limpiarHabitacion(int habitacionId, String nombreLimpiador) {
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                h.limpiarHabitacion(nombreLimpiador);
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void terminarReserva(int habitacionId) {
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                h.terminarReserva();
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void aprobarLimpieza(int habitacionId, String nombreSupervisor) {
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                if(h.getEstado()!=Ocupada.getInstancia()){
                    h.aprobarHabitacion(nombreSupervisor);
                }
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void revocarHabitacion(int habitacionId) {
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                if(h.getEstado()!=Ocupada.getInstancia() && h.getEstado()!=Limpia.getInstancia()){
                    h.revocarHabitacion();
                }
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void rechazarLimpieza(int habitacionId) {
        for (Habitacion h : habitaciones){
            if(habitacionId == h.getNumero()){
                if(h.getEstado()!=Ocupada.getInstancia() && h.getEstado()!= Aprobada.getInstancia()){
                    h.rechazarLimpieza();
                }
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public String mostrarInformacion() {
        StringBuilder output;
        output = new StringBuilder("***** " + nombre + " *****\n");
        for (Habitacion h : habitaciones){
            output.append(h.getEstado().printState(h));
            output.append("\n");
        }
        return output.toString();
    }
}
