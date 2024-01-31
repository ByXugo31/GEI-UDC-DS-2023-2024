package e1.CODIGO.Habitacion.Estado;

import e1.CODIGO.Habitacion.Habitacion;

public interface EstadoHabitacion {
    void setToOcupada(Habitacion habitacion, String supervisor);
    void setToPendienteLimpieza(Habitacion habitacion);
    void setToLimpia(Habitacion habitacion, String limpiador);
    void setToAprobada(Habitacion habitacion, String supervisor);
    String printState(Habitacion habitacion);
}
