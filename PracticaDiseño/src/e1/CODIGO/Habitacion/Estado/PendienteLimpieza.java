package e1.CODIGO.Habitacion.Estado;

import e1.CODIGO.Habitacion.Habitacion;

public class PendienteLimpieza implements EstadoHabitacion{
    private static final PendienteLimpieza instancia = new PendienteLimpieza();
    private PendienteLimpieza() { }
    public static PendienteLimpieza getInstancia() { return instancia; }

    @Override
    public void setToLimpia(Habitacion habitacion, String limpiador) {
        habitacion.setEstado(Limpia.getInstancia());
        habitacion.setLimpiador(limpiador);
    }

    @Override
    public void setToOcupada(Habitacion habitacion, String supervisor) {
        System.out.println("Habitación no aprobada.");
    }

    @Override
    public void setToPendienteLimpieza(Habitacion habitacion) {
        System.out.println("Habitación ya pendiente.");
    }

    @Override
    public void setToAprobada(Habitacion habitacion, String supervisor) {
        System.out.println("Habitación todavía pendiente de limpieza.");
    }

    @Override
    public String printState(Habitacion habitacion) {
        return "Room number: " + habitacion.getNumero() + " Free. Cleaning pending.";
    }
}
