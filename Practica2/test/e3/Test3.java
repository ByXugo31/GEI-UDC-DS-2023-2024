package e3;

import e3.Comparadores.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Test3 {
    private static Artista artista1;
    private static Artista artista2;
    private static Artista artista3;
    private static ArtitistasLista artistasLista;

    @BeforeAll
    public static void setUp() {
        //Listas de generos
        ArrayList<String> generos1 = new ArrayList<>();
        ArrayList<String> generos2 = new ArrayList<>();
        ArrayList<String> generos3 = new ArrayList<>();

        generos1.add("Pop");
        generos1.add("Rock");

        generos2.add("Pop");
        generos2.add("Rap");
        generos2.add("House");

        generos3.add("Pop");
        generos3.add("Rock");
        generos3.add("Pop");
        generos3.add("Rap");
        generos3.add("House");


        //Listas de puntuaciones
        ArrayList<Integer> puntuaciones1 = new ArrayList<>();
        ArrayList<Integer> puntuaciones2 = new ArrayList<>();
        ArrayList<Integer> puntuaciones3 = new ArrayList<>();

        puntuaciones1.add(1);
        puntuaciones1.add(5);

        puntuaciones2.add(2);
        puntuaciones2.add(2);
        puntuaciones2.add(2);

        puntuaciones3.add(9);
        puntuaciones3.add(9);
        puntuaciones3.add(6);


        //Inicializacion de los artistas
        artista1 = new Artista("1", "Artist1", new Date(1979, Calendar.SEPTEMBER,10), puntuaciones1, generos1);
        artista2 = new Artista("2", "Artist2", new Date(1995, Calendar.MARCH,1), puntuaciones2, generos2);
        artista3 = new Artista("3", "Artist3", new Date(2000,Calendar.DECEMBER,1), puntuaciones3, generos3);

        //Creacion de la coleccion de artistas
        ArrayList<Artista> artistas = new ArrayList<>();
        artistas.add(artista3);
        artistas.add(artista1);
        artistas.add(artista2);

        //Inicializacion de la coleccion de artistas
        artistasLista = new ArtitistasLista(artistas);
    }

    //Ordenar por ID
    @Test
    void ordenarPorId() {
        artistasLista.ordenar();
        assertEquals(artista1, artistasLista.getArtistas().get(0));
        assertEquals(artista2, artistasLista.getArtistas().get(1));
        assertEquals(artista3, artistasLista.getArtistas().get(2));
    }

    @Test
    public void ordenarPorNombre(){
        //Ordenación por nombre, orden alfabético (A-Z,1-9)
        artistasLista.ordenarComparador(new Nombre());
        assertEquals(artista1, artistasLista.getArtistas().get(0));
        assertEquals(artista2, artistasLista.getArtistas().get(1));
        assertEquals(artista3, artistasLista.getArtistas().get(2));
    }

    @Test
    public void ordenarPorFecha(){
        //Ordenación por fecha, de más viejo a más joven
        artistasLista.ordenarComparador(new FechaInicio());
        assertEquals(artista1, artistasLista.getArtistas().get(0));
        assertEquals(artista2, artistasLista.getArtistas().get(1));
        assertEquals(artista3, artistasLista.getArtistas().get(2));
    }

    @Test
    public void ordenarPorMedia(){
        //Ordenación por media, de mayor a menor.
        artistasLista.ordenarComparador(new Media());
        assertEquals(artista1, artistasLista.getArtistas().get(1));
        assertEquals(artista2, artistasLista.getArtistas().get(2));
        assertEquals(artista3, artistasLista.getArtistas().get(0));
    }

    @Test
    public void ordenarPorGeneros(){
        //Ordenación por número de generos de menor a mayor.
        artistasLista.ordenarComparador(new Eclecticismo());
        assertEquals(artista1, artistasLista.getArtistas().get(0));
        assertEquals(artista2, artistasLista.getArtistas().get(1));
        assertEquals(artista3, artistasLista.getArtistas().get(2));
    }
}