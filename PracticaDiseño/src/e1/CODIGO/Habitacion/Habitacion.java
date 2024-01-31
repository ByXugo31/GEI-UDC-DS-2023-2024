package e1.CODIGO.Habitacion;
import e1.CODIGO.Habitacion.Estado.EstadoHabitacion;
import e1.CODIGO.Habitacion.Estado.Aprobada;

import java.util.Objects;

public class Habitacion {
    private EstadoHabitacion estado;
    private int numero;
    private String huesped;
    private String limpiador;
    private String supervisor;


    public Habitacion(String supervisor, int numero) {
        estado = Aprobada.getInstancia();
        this.supervisor = supervisor;
        this.numero = numero;
    }


    public EstadoHabitacion getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getHuesped() {
        return huesped;
    }

    public String getLimpiador() {
        return limpiador;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    public void setLimpiador(String limpiador) {
        this.limpiador = limpiador;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void reservarHabitacion(String huesped){
        estado.setToOcupada(this,huesped);
    }

    public void terminarReserva(){
        estado.setToAprobada(this, Objects.requireNonNullElse(supervisor, "hotel"));
    }

    public void limpiarHabitacion(String limpiador){
        estado.setToLimpia(this,limpiador);
    }

    public void liberarHabitacion(){
        estado.setToPendienteLimpieza(this);
    }

    public void aprobarHabitacion(String supervisor){
        estado.setToAprobada(this,supervisor);
    }
    public void revocarHabitacion(){
        estado.setToPendienteLimpieza(this);
    }
    public void rechazarLimpieza(){
        estado.setToPendienteLimpieza(this);
    }
}
