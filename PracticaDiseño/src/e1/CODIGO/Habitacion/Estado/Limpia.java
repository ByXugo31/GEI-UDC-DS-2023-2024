package e1.CODIGO.Habitacion.Estado;

import e1.CODIGO.Habitacion.Habitacion;

public class Limpia implements EstadoHabitacion{
    private static final Limpia instancia = new Limpia();
    private Limpia() { }
    public static Limpia getInstancia() { return instancia; }

    @Override
    public void setToAprobada(Habitacion habitacion, String supervisor) {
        habitacion.setEstado(Aprobada.getInstancia());
        habitacion.setSupervisor(supervisor);
        habitacion.setLimpiador(null);
    }

    @Override
    public void setToPendienteLimpieza(Habitacion habitacion) {
        habitacion.setEstado(Ocupada.getInstancia());
    }

    @Override
    public void setToLimpia(Habitacion habitacion, String limpiador) {
        System.out.println("Habitación ya está limpia.");
    }

    @Override
    public void setToOcupada(Habitacion habitacion, String huesped) {
        System.out.println("Habitación no aprobada.");
    }

    @Override
    public String printState(Habitacion habitacion) {
        return "Room number: " + habitacion.getNumero() + " Free. Pending approval, cleaned by: " + habitacion.getLimpiador() + ".";
    }
}
