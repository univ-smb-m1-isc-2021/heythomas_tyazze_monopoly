import java.util.ArrayList;
import java.util.*;

public class Partie {
    public int joueurCourant=0;

    public List<Joueur> joueur = new ArrayList<Joueur> ();

    public Plateau plateau;

    public List<De> de = new ArrayList<De> ();

    public void inscrireJoueur(String name) {
    	joueur.add(new Joueur(name));
    }

    public void lancerJeu() {
    	definirOrdre();
    	for(int i = 0; i < joueur.size(); i++) {
    		joueur.get(i).estSur = plateau.cases.get(0);
    	}
    	lancerPartie();
    }

    public void definirOrdre() {
    	Collections.shuffle(joueur);
    }

    public void lancerPartie() {
    	boolean game = true;
    	while(game) {
    		System.out.println("Au tour de " + joueur.get(joueurCourant).nom + ", actuellement sur la case \"" + joueur.get(joueurCourant).estSur.nom + "\"");
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
    	System.out.println("Partie termin�e, gagnant : " + joueur.get(0).nom);
    }
    
    public static void main(String[] args) {
    	Partie partie = new Partie();
    	
    	Plateau plateau = new Plateau();
    	plateau.cases.add(new Kase("Case 1"));
    	plateau.cases.add(new Kase("Case 2"));
    	plateau.cases.add(new Kase("Case 3"));
    	plateau.cases.add(new Kase("Case 4"));
    	plateau.cases.add(new Kase("Case 5"));
    	plateau.genererCases();
    	partie.plateau = plateau;
    	
    	partie.inscrireJoueur("Thomas");
    	partie.inscrireJoueur("Pierrot");
    	
    	partie.lancerJeu();
    }
}
