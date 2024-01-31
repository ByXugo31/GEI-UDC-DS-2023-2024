package e3;

import java.util.Objects;

public record Track(String posicion, String grabacion, String artista, String titulo, int duracion) {
    public Track {
        if (posicion == null || grabacion == null || artista == null || titulo == null || duracion < 0) {
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos y la duración no puede ser negativa.");
        }
    }
    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Track track = (Track) object;
        return Objects.equals(grabacion, track.grabacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grabacion);
    }

    @Override
    public String toString() {return "Posición: " + this.posicion + "\nDuración: " + this.duracion + "\nGrabación: " + this.grabacion + "\n";}



}
