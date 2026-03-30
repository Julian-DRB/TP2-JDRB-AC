package livres;

public class OuvrageAudio extends Ouvrage{
    private int dureeMinutes;
    private String format;

    public OuvrageAudio(String titre, Auteur auteur, int dureeMinutes, String format) {
        super(titre, auteur);
        setDureeMinutes(dureeMinutes);
        setFormat(format);
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        if (dureeMinutes < 0) {
            System.out.println("La durée doit être positive")
        }
        this.dureeMinutes = dureeMinutes;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + " - Audio : " + dureeMinutes + " min, Format : " + format;
    }
}