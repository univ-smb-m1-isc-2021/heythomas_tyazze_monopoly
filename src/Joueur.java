
public class Joueur {
	public String nom;
	
    public float solde;

    public Kase estSur;

    public CasePropriete casePropriete;
    
    public De de = new De();

    public boolean jouer() {
    	deplacer(lancerDe());
    	System.out.println(nom + " est sur la case \"" + estSur.nom + "\"");
    	return true;
    }

    public int lancerDe() {
    	return de.lancer();
    }

    public void deplacer(final int nombreCase) {
    	for(int i=0; i < nombreCase; i++) {
    		estSur = estSur.suivant();
    	}
    	estSur.atterrirSurCase(this);
    }

    public void acheterCase() {
    	estSur.achat();
    }

    public void acheterMaison() {
    	// TODO
    }

    public void finTour() {
    	// DEPRECATED
    }

    public boolean possedeSolde(float montant) {
    	if(solde > montant) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public void payerLoyer() {
    	// TODO
    }

    public void crediter(final float somme) {
    	solde += somme;
    }

    public void construire(final Kase kase) {
    	// TODO
    }
    
    public Joueur(String name) {
    	nom = name;
    }

}
