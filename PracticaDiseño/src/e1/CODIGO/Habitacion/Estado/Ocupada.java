package e1.CODIGO.Habitacion.Estado;

import e1.CODIGO.Habitacion.Habitacion;

public class Ocupada implements EstadoHabitacion{
    private static final Ocupada instancia = new Ocupada();
    private Ocupada() { }
    public static Ocupada getInstancia() { return instancia; }

    @Override
    public void setToPendienteLimpieza(Habitacion habitacion) {
        habitacion.setEstado(PendienteLimpieza.getInstancia());
        habitacion.setHuesped(null);
    }

    @Override
    public void setToAprobada(Habitacion habitacion, String supervisor) {
        habitacion.setEstado(Aprobada.getInstancia());
        habitacion.setHuesped(null);
    }

    @Override
    public void setToOcupada(Habitacion habitacion, String supervisor) {
        System.out.println("Habitación ya está ocupada.");
    }

    @Override
    public void setToLimpia(Habitacion habitacion, String limpiador) {
        System.out.println("Habitación no pendiente.");
    }

    @Override
    public String printState(Habitacion habitacion) {
        return "Room number: " + habitacion.getNumero() + " Booked by: " + habitacion.getHuesped() + " Occupied.";
    }
}
