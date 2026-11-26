import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {//B2
        
      //initialisation
        // Le Scanner permet de lire la saisie de l'utilisateur dans la console
        Scanner scanner = new Scanner(System.in);
        
        // Liste principale stockant tous les continents créés
        ArrayList<Continent> listeContinents = new ArrayList<>();

        // Création de quelques données par défaut pour pouvoir tester immédiatement
        Continent europe = new Continent("Europe", "Hémisphère Nord");
        Capitale paris = new Capitale("Paris", 2161000, 105);
        Pays france = new Pays("France", "Français", "Euro", paris);
        france.ajouteruneVille("Lyon", 522000, 48);
        europe.ajouterunPays(france);
        listeContinents.add(europe);

        // Variable pour stocker le choix saisi par l'utilisateur
        int choix = 0;

        
        //  BOUCLE PRINCIPALE DU MENU (do ... while)
        // La boucle s'exécute en continu jusqu'à ce que l'utilisateur choississe 7
        // ------------------------------------------------------------------------
        do {
            // Affichage des options du menu à l'écran
            System.out.println("\n=== MENU APPLICATION PAYS/CONTINENTS ===");
            System.out.println("1. Afficher tous les continents");
            System.out.println("2. Ajouter un continent");
            System.out.println("3. Ajouter un pays à un continent");
            System.out.println("4. Ajouter une ville à un pays");
            System.out.println("5. Rechercher une ville dans un pays");
            System.out.println("6. Supprimer une ville d'un pays");
            System.out.println("7. Quitter");
            System.out.print("Choix : ");

            // Vérification si la saisie est bien un nombre entier 
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine(); // Astuce : consomme le retour à la ligne restant dans le buffer
            } else {
                scanner.nextLine(); // Vide le texte invalide saisi
                choix = 0; // Affecte un choix hors menu pour déclencher l'option par défaut
            }

           //traitement du choix swicth
            switch (choix) {
                
                // OPTION 1 : Affichage des données
                case 1:
                    if (listeContinents.isEmpty()) {
                        System.out.println("Aucun continent enregistré.");
                    } else {
                        // Parcours et affichage de chaque continent
                        for (Continent c : listeContinents) {
                            System.out.println(c);
                        }
                    }
                    break;

                // OPTION 2 : Créer un nouveau continent
                case 2:
                    System.out.print("Nom du continent : ");
                    String nomC = scanner.nextLine();
                    System.out.print("Localisation : ");
                    String locC = scanner.nextLine();
                    
                    // Ajout à la liste globale
                    listeContinents.add(new Continent(nomC, locC));
                    System.out.println("Continent ajouté !");
                    break;

                // OPTION 3 : Créer et ajouter un pays dans un continent existant
                case 3:
                    System.out.print("Nom du continent cible : ");
                    String targetC = scanner.nextLine();
                    
                    // Recherche du continent correspondant dans la liste
                    Continent contTrouve = null;
                    for (Continent c : listeContinents) {
                        if (c.getNom().equalsIgnoreCase(targetC)) {
                            contTrouve = c;
                            break; // On arrête la recherche une fois trouvé
                        }
                    }
                    
                    if (contTrouve != null) {
                        System.out.print("Nom du pays : ");
                        String nomP = scanner.nextLine();
                        System.out.print("Langue : ");
                        String langueP = scanner.nextLine();
                        System.out.print("Monnaie : ");
                        String monnaieP = scanner.nextLine();
                        
                        // Ajout du pays au continent trouvé
                        contTrouve.ajouterunPays(new Pays(nomP, langueP, monnaieP));
                        System.out.println("Pays ajouté à " + contTrouve.getNom());
                    } else {
                        System.out.println("Continent non trouvé.");
                    }
                    break;

                // OPTION 4 : Créer et ajouter une ville dans un pays existant
                case 4:
                    System.out.print("Nom du pays cible : ");
                    String targetP = scanner.nextLine();
                    
                    // Recherche du pays à travers tous les continents
                    Pays paysTrouve = null;
                    for (Continent c : listeContinents) {
                        Pays p = c.rechercherPays(targetP);
                        if (p != null) {
                            paysTrouve = p;
                            break;
                        }
                    }
                    
                    if (paysTrouve != null) {
                        System.out.print("Nom de la ville : ");
                        String nomV = scanner.nextLine();
                        System.out.print("Nombre d'habitants : ");
                        int nbHab = scanner.nextInt();
                        System.out.print("Superficie : ");
                        int sup = scanner.nextInt();
                        scanner.nextLine(); // Consomme la fin de ligne du dernier entier
                        
                        // Ajout de la ville au pays trouvé
                        paysTrouve.ajouteruneVille(nomV, nbHab, sup);
                        System.out.println("Ville ajoutée à " + paysTrouve.getNom());
                    } else {
                        System.out.println("Pays non trouvé.");
                    }
                    break;

                // OPTION 5 : Rechercher une ville
                case 5:
                    System.out.print("Nom du pays : ");
                    String pRech = scanner.nextLine();
                    
                    Pays paysR = null;
                    for (Continent c : listeContinents) {
                        Pays p = c.rechercherPays(pRech);
                        if (p != null) {
                            paysR = p;
                            break;
                        }
                    }
                    
                    if (paysR != null) {
                        System.out.print("Nom de la ville à chercher : ");
                        String vRech = scanner.nextLine();
                        
                        // Utilisation de la recherche d'objet ville dans le pays
                        Ville v = paysR.rechercheruneVilleObjet(vRech);
                        System.out.println(v != null ? "Trouvée : " + v : "Ville non trouvée.");
                    } else {
                        System.out.println("Pays non trouvé.");
                    }
                    break;

                // OPTION 6 : Supprimer une ville
                case 6:
                    System.out.print("Nom du pays : ");
                    String pSupp = scanner.nextLine();
                    
                    Pays paysS = null;
                    for (Continent c : listeContinents) {
                        Pays p = c.rechercherPays(pSupp);
                        if (p != null) {
                            paysS = p;
                            break;
                        }
                    }
                    
                    if (paysS != null) {
                        System.out.print("Nom de la ville à supprimer : ");
                        String vSupp = scanner.nextLine();
                        
                        // Appel de la méthode de suppression par nom de ville
                        boolean suppr = paysS.SuppUneVille(vSupp);
                        System.out.println(suppr ? "Ville supprimée !" : "Ville non trouvée.");
                    } else {
                        System.out.println("Pays non trouvé.");
                    }
                    break;

                // OPTION 7 : Sortie du programme
                case 7:
                    System.out.println("Fin du programme.");
                    break;

                // CAS PAR DÉFAUT : En cas de saisie d'un choix non prévu
                default:
                    System.out.println("Choix invalide, veuillez rechoisir.");
            }
            
        } while (choix != 7); // Si le choix est 7, la condition devient fausse et la boucle s'arrête

        // Fermeture du Scanner 
        scanner.close();
    }
}