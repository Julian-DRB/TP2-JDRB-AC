package livres;

public class Pays {
    private String nom;
    private String code;

    public Pays(String nom, String code) {
        
        setNom;
        setCode;
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setCode(String code){
        if (!code.matches("[A-Z]{3}")) {
            System.out.println("Le code doit OBLIGATOIREMENT contenir 3 lettres MAJUSCULES");
        }
        this.code = code;
    }
}