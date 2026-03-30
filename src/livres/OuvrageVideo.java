/**
 *
 * @author Julian David Rodriguez
 * @since H26
 */
package livres;

import java.time.LocalDate;

public class OuvrageVideo extends Ouvrage {

    private int dureeMinutes;
    private int tailleMb;

    public OuvrageVideo(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int dureeMinutes, int tailleMb) {
        super(titre, auteur, date, nombreExemplaires);
        this.dureeMinutes = dureeMinutes;
        this.tailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur, int dureeMinutes, int tailleMb) {
        super(titre, auteur);
        this.dureeMinutes = dureeMinutes;
        this.tailleMb = tailleMb;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public int getTailleMb() {
        return tailleMb;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + dureeMinutes + " min - " + tailleMb + " Mb";
    }
}