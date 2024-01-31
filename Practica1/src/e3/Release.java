package e3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import e3.Track;

public class Release {
    private String id;
    private String titulo;
    private String artistaPrincipal;
    private List<Track> pistas;

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtistaPrincipal() {
        return artistaPrincipal;
    }

    public List<Track> getPistas() {
        return pistas;
    }

    public Release(String str) {
        if (str.isBlank() || str.isEmpty()) throw new IllegalArgumentException("Id no válido");
        this.id = str;
    }

    public void setTitle(String str) {
        if (str.isBlank() || str.isEmpty()) throw new IllegalArgumentException("Título no válido");
        this.titulo = str;
    }

    public void setArtist(String str) {
        if (str.isBlank() || str.isEmpty()) throw new IllegalArgumentException("Artista no válido");
        this.artistaPrincipal = str;
    }

    public void addTrack(Track pista) {
        if (this.pistas == null) this.pistas = new ArrayList<>();
        this.pistas.add(pista);
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "\nTítulo: " + this.titulo + "\nArtista Principal: " + this.artistaPrincipal + "\nPistas: " + this.pistas + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Track pista : this.pistas) hash += pista.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Release release = (Release) obj;
        boolean aux = false;
        if (this.pistas.size() != release.pistas.size()) return false;
        for (Track pista : this.pistas) {
            for (Track pista2 : release.pistas){
                if (pista.grabacion().equals(pista2.grabacion())){
                    aux = true;
                    break;
                }
                aux = false;
            }
            if(!aux) return aux;
        }
        return aux;
    }
}
