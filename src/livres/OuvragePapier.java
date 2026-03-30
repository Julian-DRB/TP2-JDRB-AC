package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage {

    private int nombrePages;

    public OuvragePapier(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int nombrePages) {
        super(titre, auteur, date, nombreExemplaires);
        this.nombrePages = nombrePages;
    }

    public OuvragePapier(String titre, Auteur auteur, int nombrePages) {
        super(titre, auteur);
        this.nombrePages = nombrePages;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + nombrePages + " pages";
    }
}
