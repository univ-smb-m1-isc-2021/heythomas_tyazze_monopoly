package main;
import java.util.Scanner;

public class Joueur {
	public String nom;
	
    public float solde;

    public Kase estSur;

    public CasePropriete casePropriete;
    
    public De de = new De();
    
    // Tour d'un joueur
    public boolean jouer() {
    	// Deplacement lors du tour
    	System.out.println(nom + " possede " + solde + "e");
    	boolean res = deplacer(lancerDe());
    	System.out.println(nom + " arrive sur la case " + estSur.nom);
    	
    	// Si le terrain est libre et achetable, on propose l'achat
    	@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
    	if(!res) {
            System.out.println("Voulez vous acheter la case \"" + estSur.nom + "\" ? 1=Oui 2=Non");
            int result = scn.nextInt();
            if(result == 1) {
            	estSur.achat(this);
            }
    	}
            
        // Proposition achat de maisons
    	int tmp;
        while(true) {
            System.out.println("Voulez vous acheter des proprietes ? 1=Oui 2=Non");
            tmp = scn.nextInt();
            if(tmp == 1) {
            	Kase temp = estSur;
                for(int i = 0; i < 40; i++) {
                	if(temp.estConstructible(this)) {
                		System.out.println("Voulez vous acheter pour " + temp.nom + " ? 1=Oui 2=Non");
                		tmp = scn.nextInt();
                		if(tmp == 1) {
                        	if(temp.construire(this)) {
                        		System.out.println("Achat reussi");
                        	}
                        	else {
                        		System.out.println("Achat echoue");
                        	}
                		}
                	}
                	temp = temp.suivant;
                }
            }
            else if(tmp == 2) {
            	break;
            }
        }
    	return true;
    }
    
    // De
    public int lancerDe() {
    	return de.lancer();
    }
    
    // Systeme de deplacement, bloc --> suivant
    public boolean deplacer(final int nombreCase) {
    	for(int i=0; i < nombreCase; i++) {
    		estSur = estSur.suivant();
    	}
    	return estSur.atterrirSurCase(this);
    }
    
    // Pas utilise (integre a jouer() mais revient au meme)
    public void acheterCase() {
    	estSur.achat(this);
    }
    
    // Faillite
    public void finTour() {
    	// DEPRECATED
    	System.out.println("Faillite, fin de partie !");
    }
    
    // Verification porte monnaie
    public boolean possedeSolde(float montant) {
    	if(solde > montant) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    // Recuperer de l'argent
    public void crediter(final float somme) {
    	solde += somme;
    }
    
    // Construction sur un terrain disponible
    public boolean construire(final Kase kase) {
    	return estSur.construire(this);
    }
    
    // Constructeur
    public Joueur(String name) {
    	nom = name;
    	solde = 1500;
    }

}
