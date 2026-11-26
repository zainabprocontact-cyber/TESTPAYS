import java.util.ArrayList;

public class Pays {
    private String nom;
    private String langue;
    private String monnaie;

    private Capitale saCapitale;
    public static int nbpays;

    // Point 5
    private ArrayList<Ville> lesVilles;

    // Accesseurs
    public static int getNbpays() {
        return nbpays;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String unNom) {
        this.nom = unNom;
    }

    public String getLangue() {
        return this.langue;
    }

    public void setLangue(String unlangue) {
        this.langue = unlangue;
    }

    public String getMonnaie() {
        return this.monnaie;
    }

    public void setMonnaie(String uneMonnaie) {
        this.monnaie = uneMonnaie;
    }

    public Capitale getSaCapitale() {
        return saCapitale;
    }

    public void setSaCapitale(Capitale saCapitale) {
        this.saCapitale = saCapitale;
    }

    public ArrayList<Ville> getLesVillesList() {
        return lesVilles;
    }

    // Constructeurs
    public Pays() {
        nbpays = nbpays + 1;
        this.lesVilles = new ArrayList<Ville>();
    }

    public Pays(String unNom, String unlangue, String uneMonnaie) {
        this.nom = unNom;
        this.langue = unlangue;
        this.monnaie = uneMonnaie;
        this.lesVilles = new ArrayList<Ville>();
        nbpays = nbpays + 1;
    }

    public Pays(String unNom, String unlangue, String uneMonnaie, Capitale SaCapitale) {
        this.nom = unNom;
        this.langue = unlangue;
        this.monnaie = uneMonnaie;
        this.saCapitale = SaCapitale;
        this.lesVilles = new ArrayList<Ville>();
        nbpays = nbpays + 1;
    }

    public String NomMaj() {
        return this.getNom() != null ? this.getNom().toUpperCase() : "";
    }

    private String getNomFormate() {
        return "(" + this.nom + ")";
    }

    // Gestion des villes
    public void ajouterUneVille(Ville uneVille) {
        if (!this.lesVilles.contains(uneVille)) {
            this.lesVilles.add(uneVille);
            uneVille.setSonPays(this);
        }
    }

    // Surcharge avec types corrects
    public void ajouteruneVille(String unNom, int unNbhabitants, int uneSuperficie) {
        Ville uneVille = new Ville(unNom, unNbhabitants, uneSuperficie, this);
    }

    // Suppression par objet
    public void SuppUneVille(Ville uneVille) {
        this.lesVilles.remove(uneVille);
    }

    // Suppression par nom
    public boolean SuppUneVille(String unNom) {
        Ville v = rechercheruneVilleObjet(unNom);
        if (v != null) {
            this.lesVilles.remove(v);
            return true;
        }
        return false;
    }

    // Nb de villes
    public int getNbVilles() {
        return this.lesVilles.size();
    }

    // Recherche booléenne
    public boolean rechercheruneVille(String unNom) {
        return rechercheruneVilleObjet(unNom) != null;
    }

    // Recherche objet
    public Ville rechercheruneVilleObjet(String unNom) {
        for (Ville v : this.lesVilles) {
            if (v.getNom().equalsIgnoreCase(unNom)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String chaine = "";
        chaine += "Pays [nom=" + this.getNomFormate() + ", langue=" + this.langue + ", monnaie=" + this.monnaie + ", capitale=" + this.saCapitale + "]";
        chaine += " Ses villes sont :" + this.lesVilles;
        return chaine;
    }
}
