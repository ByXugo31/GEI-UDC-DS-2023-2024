package e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArtitistasLista {
    private final ArrayList<Artista> artistas;
    public ArtitistasLista(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }
    public void ordenar(){
        Collections.sort(artistas);
    }
    public void ordenarComparador(Comparator<Artista> comparador){
        Collections.sort(artistas,comparador);
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }
}
