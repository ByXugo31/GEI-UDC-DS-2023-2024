package e1.CODIGO.Habitacion.Estado;

import e1.CODIGO.Habitacion.Habitacion;

public class Aprobada implements EstadoHabitacion{
    private static final Aprobada instancia = new Aprobada();
    private Aprobada() { }
    public static Aprobada getInstancia() { return instancia; }

    @Override
    public void setToOcupada(Habitacion habitacion, String huesped) {
        habitacion.setEstado(Ocupada.getInstancia());
        habitacion.setHuesped(huesped);
    }

    @Override
    public void setToPendienteLimpieza(Habitacion habitacion) {
        habitacion.setEstado(Ocupada.getInstancia());
    }

    @Override
    public void setToLimpia(Habitacion habitacion, String limpiador) {
        System.out.println("Habitación ya aprobada.");
    }

    @Override
    public void setToAprobada(Habitacion habitacion, String supervisor) {
        System.out.println("Habitación ya aprobada.");
    }

    @Override
    public String printState(Habitacion habitacion) {
        return "Room number: " + habitacion.getNumero() + " Free. Approved by: " + habitacion.getSupervisor() + ".";
    }
}
