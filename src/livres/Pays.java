public class Pays {
    private String nom;
    private String code;

    public Pays(String nom, String code) {
        if (!code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Le code doit contenir exactement 3 lettres majuscules");
        }
        this.nom = nom;
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public void setNom(){
        this.nom = nom;
    }

    public void setCode(){
        this.code = code
    }
}