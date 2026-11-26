public class Capitale extends Ville {

    // Constructeurs
    public Capitale() {
        super();
    }

    public Capitale(String unNom, int unNbhabitants, int uneSuperficie) {
        super(unNom, unNbhabitants, uneSuperficie);
    }

    public Capitale(String unNom, int unNbhabitants, int uneSuperficie, Pays unPays) {
        super(unNom, unNbhabitants, uneSuperficie, unPays);
    }

    @Override
    public String toString() {
        return "Capitale [nom=" + getNom() + ", nbhabitants=" + getNbhabitants() + ", superficie=" + getSuperficie() + "]";
    }
}
