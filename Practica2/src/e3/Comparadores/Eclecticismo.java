package e3.Comparadores;

import e3.Artista;

import java.util.Comparator;

public class Eclecticismo implements Comparator<Artista> {
    @Override
    public int compare(Artista o1, Artista o2) {
        return (Integer.compare(o1.getGeneros().size(),o2.getGeneros().size()));
    }
}
