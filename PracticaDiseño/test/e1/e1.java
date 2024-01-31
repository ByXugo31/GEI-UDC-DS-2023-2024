package e1;

import e1.CODIGO.Habitacion.Estado.Aprobada;
import e1.CODIGO.Habitacion.Estado.Ocupada;
import e1.CODIGO.Habitacion.Estado.PendienteLimpieza;
import e1.CODIGO.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class e1{
    private static Hotel hotel;
    @BeforeEach
    public void setUp(){
        hotel = new Hotel("Test hotel");
    }

    @Test
    public void AnadirHabitacion(){
        hotel.addHabitacion("Hugo");
        assertEquals("***** Test hotel *****\nRoom number: 1 Free. Approved by: Hugo.\n",hotel.mostrarInformacion());
        hotel.addHabitacion("Anton");
        assertEquals("***** Test hotel *****\nRoom number: 1 Free. Approved by: Hugo.\nRoom number: 2 Free. Approved by: Anton.\n",hotel.mostrarInformacion());
    }

    @Test
    public void CambiarEstados(){
        //Reservamos todas las habitaciones.
        hotel.addHabitacion("Pedro");
        hotel.addHabitacion("Lucas");
        hotel.addHabitacion("Paco");
        hotel.addHabitacion("Angel");
        hotel.reservarHabitacion(1,"Paco");
        hotel.reservarHabitacion(2,"Juan");
        hotel.reservarHabitacion(3,"Anton");
        hotel.reservarHabitacion(4,"Hugo");
        assertEquals("***** Test hotel *****\nRoom number: 1 Booked by: Paco Occupied.\n" +
                "Room number: 2 Booked by: Juan Occupied.\n" +
                "Room number: 3 Booked by: Anton Occupied.\n" +
                "Room number: 4 Booked by: Hugo Occupied.\n",hotel.mostrarInformacion());

        //Liberamos y cancelamos reserva de 2 habitaciones.
        hotel.liberarHabitacion(1);
        hotel.terminarReserva(2);
        assertEquals("***** Test hotel *****\nRoom number: 1 Free. Cleaning pending.\n" +
                "Room number: 2 Free. Approved by: Lucas.\n" +
                "Room number: 3 Booked by: Anton Occupied.\n" +
                "Room number: 4 Booked by: Hugo Occupied.\n",hotel.mostrarInformacion());

        //Liberamos una habitacion y limpiamos otra y reservamos otra.
        hotel.liberarHabitacion(3);
        hotel.reservarHabitacion(2,"Anton");
        hotel.limpiarHabitacion(1,"Paco");
        assertEquals("***** Test hotel *****\nRoom number: 1 Free. Pending approval, cleaned by: Paco.\n" +
                "Room number: 2 Booked by: Anton Occupied.\n" +
                "Room number: 3 Free. Cleaning pending.\n" +
                "Room number: 4 Booked by: Hugo Occupied.\n",hotel.mostrarInformacion());

        //Aprobamos una habitación
        hotel.aprobarLimpieza(1,"Pedro");
        assertEquals("***** Test hotel *****\nRoom number: 1 Free. Approved by: Pedro.\n" +
                "Room number: 2 Booked by: Anton Occupied.\n" +
                "Room number: 3 Free. Cleaning pending.\n" +
                "Room number: 4 Booked by: Hugo Occupied.\n",hotel.mostrarInformacion());
    }

    @Test
    public void CambiarEstadoNoValido(){
        hotel.addHabitacion("Ramon");
        hotel.addHabitacion("Antonio");
        hotel.addHabitacion("Marco");
        hotel.addHabitacion("Emilio");

        hotel.limpiarHabitacion(1,"Anton");
        hotel.aprobarLimpieza(1,"Hugo");
        hotel.liberarHabitacion(1);
        hotel.terminarReserva(1);
        assertEquals(hotel.getHabitacion(1).getEstado(),Aprobada.getInstancia());

        hotel.reservarHabitacion(2,"Hugo");

        hotel.reservarHabitacion(2,"Paco");
        hotel.limpiarHabitacion(2,"Anton");
        hotel.aprobarLimpieza(2,"Hugo");
        assertEquals(hotel.getHabitacion(2).getEstado(), Ocupada.getInstancia());

        hotel.reservarHabitacion(3,"Anton");
        hotel.liberarHabitacion(3);

        hotel.reservarHabitacion(3,"Paco");
        hotel.liberarHabitacion(3);
        hotel.aprobarLimpieza(3,"Hugo");
        hotel.terminarReserva(3);
        assertEquals(hotel.getHabitacion(3).getEstado(), PendienteLimpieza.getInstancia());

        hotel.reservarHabitacion(4,"Anton");
        hotel.liberarHabitacion(4);
        hotel.limpiarHabitacion(4,"Juan");

        hotel.reservarHabitacion(4,"Paco");
        hotel.liberarHabitacion(4);
        hotel.terminarReserva(4);
        hotel.limpiarHabitacion(4,"Anton");
        assertEquals(hotel.getHabitacion(3).getEstado(), PendienteLimpieza.getInstancia());
    }
}