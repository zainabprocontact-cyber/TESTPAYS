public class Ville {
    private String nom;
    private int nbhabitants;
    private int superficie;
    private Pays sonPays;

    // Accesseurs
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getNbhabitants() {
        return nbhabitants;
    }
    public void setNbhabitants(int nbhabitants) {
        this.nbhabitants = nbhabitants;
    }
    public int getSuperficie() {
        return superficie;
    }
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public Pays getSonPays() {
        return this.sonPays;
    }
    
    public void setSonPays(Pays unPays) {
        this.sonPays = unPays;
    }

    // Méthodes
    @Override
    public String toString() {
        return "Ville [nom=" + nom + ", nbhabitants=" + nbhabitants + ", superficie=" + superficie + "]";
    }

    // Constructeurs
    public Ville() {
    }

    public Ville(String unNom, int unNbhabitants, int uneSuperficie) {
        this.nom = unNom;
        this.nbhabitants = unNbhabitants;
        this.superficie = uneSuperficie;
    }

    public Ville(String unNom, int unNbhabitants, int uneSuperficie, Pays unPays) {
        this.nom = unNom;
        this.nbhabitants = unNbhabitants;
        this.superficie = uneSuperficie;
        this.sonPays = unPays;
        if (unPays != null) {
            unPays.ajouterUneVille(this);
        }
    }
}
