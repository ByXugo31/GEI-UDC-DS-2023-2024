package e3.Comparadores;
import e3.Artista;
import java.util.Comparator;

public class Media implements Comparator<Artista> {
    private int getMedia(Artista o){
        int media = 0;
        for (int puntuacion : o.getPuntuaciones()){
            media+=puntuacion;
        }
        return media/o.getPuntuaciones().size();
    }
    @Override
    public int compare(Artista o1, Artista o2) {
        return (Integer.compare(getMedia(o1),getMedia(o2))*(-1));
    }
}
