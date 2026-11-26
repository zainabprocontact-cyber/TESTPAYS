import java.util.ArrayList;

public class Continent {
    private String nom;
    private String localisation;
    private ArrayList<Pays> lesPays;

    public Continent() {
        this.lesPays = new ArrayList<Pays>();
    }

    public Continent(String unNom, String laLocalisation) {
        this.nom = unNom;
        this.localisation = laLocalisation;
        this.lesPays = new ArrayList<Pays>();
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getLocalisation() {
        return localisation;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public ArrayList<Pays> getLesPays() {
        return lesPays;
    }

    public void ajouterunPays(Pays unPays) {
        this.lesPays.add(unPays);
    }

    public Pays rechercherPays(String unNom) {
        for (Pays p : lesPays) {
            if (p.getNom().equalsIgnoreCase(unNom)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Continent [nom=" + this.nom + ", localisation=" + this.localisation + ", lesPays=" + this.lesPays + "]";
    }
}