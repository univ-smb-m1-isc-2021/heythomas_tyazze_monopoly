import java.util.ArrayList;
import java.util.*;

public class Partie {
    public int joueurCourant=0;

    public List<Joueur> joueur = new ArrayList<Joueur> ();

    public Plateau plateau;

    public List<De> de = new ArrayList<De> ();
    
    // Incription des joueurs
    public void inscrireJoueur(String name) {
    	joueur.add(new Joueur(name));
    }
    
    // Appel a la boucle de jeu apres melange
    public void lancerJeu() {
    	definirOrdre();
    	for(int i = 0; i < joueur.size(); i++) {
    		joueur.get(i).estSur = plateau.cases.get(0);
    	}
    	lancerPartie();
    }
    
    // On melange la liste des joueurs
    public void definirOrdre() {
    	Collections.shuffle(joueur);
    }
    
    // Boucle de jeu, donnant la main a tous les joueurs
    public void lancerPartie() {
    	boolean game = true;
    	while(game) {
    		System.out.println("\n====================\n\nAu tour de " + joueur.get(joueurCourant).nom + ", actuellement sur la case \"" + joueur.get(joueurCourant).estSur.nom + "\"");
    		game = joueur.get(joueurCourant).jouer();
    		if(joueurCourant == joueur.size()-1) {
    			joueurCourant = 0;
    		}
    		else {
    			joueurCourant++;
    		}
    	}    
    }

    public int lancerDe() {
        de.get(0).lancer();
        return 0;
    }

    /*public void finTour() {
    }*/

    public void finPartie() {
    	System.out.println("Partie terminee, gagnant : " + joueur.get(0).nom);
    }
    
    public static void main(String[] args) {
    	Partie partie = new Partie();
    	
    	Plateau plateau = new Plateau();
    	
    	//quartiers
    	Quartier quartierGare = new Quartier("nom 2", 2, 3);
    	Quartier quartierService = new Quartier("nom 3", 2, 2);
    	
    	Quartier quartierMarron = new Quartier("Marron", 2, 2);
    	Quartier quartierBleuCiel = new Quartier("Bleu Ciel", 2, 3);
    	
    	Quartier quartierRose = new Quartier("Rose", 2, 3);
    	Quartier quartierOrange = new Quartier("Orange", 2, 3);
    	
    	Quartier quartierRouge = new Quartier("Rouge", 2, 3);
    	Quartier quartierJaune = new Quartier("Jaune", 2, 3);
    	
    	Quartier quartierVert = new Quartier("Vert", 2, 3);
    	Quartier quartierBleuFonce = new Quartier("Bleu Fonce", 2, 2);
    	
    	//kases
    	//cote sud
    	plateau.cases.add(new Kase("Depart"));
    	plateau.cases.add(new Terrain("Boulevard de Belleville", 10, 60, quartierMarron, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Caisse Communaute"));
    	plateau.cases.add(new Terrain("Rue Lecourbe", 12, 60, quartierMarron, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Impot sur le revenu"));
    	plateau.cases.add(new Gare("Gare Montparnasse", 0, 200, quartierGare, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Rue de Vaugirard", 15, 100, quartierBleuCiel, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Chance"));
    	plateau.cases.add(new Terrain("Rue de Courcelles", 15, 100, quartierBleuCiel, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Avenue de la Republique", 17, 120, quartierBleuCiel, new etatCasePropriete()));
    	
    	//cote ouest
    	plateau.cases.add(new Kase("Prison"));
    	plateau.cases.add(new Terrain("Boulevard de la Villette", 20, 140, quartierRose, new etatCasePropriete()));
    	plateau.cases.add(new Service("Service de l'electricite", 0, 150, quartierService, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Avenue de Neuilly", 20, 140, quartierRose, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Rue de Paradis", 22, 160, quartierRose, new etatCasePropriete()));
    	plateau.cases.add(new Gare("Gare de Lyon", 0, 200, quartierGare, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Avenue Mozart", 25, 180, quartierOrange, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Caisse Communaute"));
    	plateau.cases.add(new Terrain("Rue de Courcelles", 25, 180, quartierOrange, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Avenue de la Republique", 27, 200, quartierOrange, new etatCasePropriete()));
    	
    	//cote nord
    	plateau.cases.add(new Kase("Parc"));
    	plateau.cases.add(new Terrain("Avenue Matignon", 30, 220, quartierRouge, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Chance"));
    	plateau.cases.add(new Terrain("Boulevard Malesherbes", 30, 220, quartierRouge, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Avenue Henry Martin", 32, 240, quartierRouge, new etatCasePropriete()));
    	plateau.cases.add(new Gare("Gare du Nord", 0, 200, quartierGare, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Faubourg Saint Honore", 35, 260, quartierJaune, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Place de la Bourse", 35, 260, quartierJaune, new etatCasePropriete()));
    	plateau.cases.add(new Service("Service des eaux", 0, 150, quartierService, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Rue de Rivoli", 37, 280, quartierJaune, new etatCasePropriete()));
    	
    	//cote est
    	plateau.cases.add(new Kase("Allez en prison"));
    	plateau.cases.add(new Terrain("Avenue de Breteuil", 40, 300, quartierVert, new etatCasePropriete()));
    	plateau.cases.add(new Terrain("Avenue Foch", 40, 300, quartierVert, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Caisse Communaute"));
    	plateau.cases.add(new Terrain("Boulevard des Capucines", 42, 320, quartierVert, new etatCasePropriete()));
    	plateau.cases.add(new Gare("Gare Saint Lazaire", 0, 200, quartierGare, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Chance"));
    	plateau.cases.add(new Terrain("Avenue des Champs Elyse", 45, 350, quartierBleuFonce, new etatCasePropriete()));
    	plateau.cases.add(new Kase("Taxe de luxe"));
    	plateau.cases.add(new Terrain("Rue de la paix", 50, 400, quartierBleuFonce, new etatCasePropriete()));
    	
    	plateau.genererCases();
    	partie.plateau = plateau;
    	
    	partie.inscrireJoueur("Thomas");
    	partie.inscrireJoueur("Benjamin");
    	
    	partie.lancerJeu();
    }
}
