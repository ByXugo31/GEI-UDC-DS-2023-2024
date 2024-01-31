package e3.Comparadores;

import e3.Artista;
import java.util.Comparator;

public class FechaInicio implements Comparator<Artista> {
    @Override
    public int compare(Artista o1, Artista o2) {
        return o1.getFechaInicio().compareTo(o2.getFechaInicio());
    }
}
