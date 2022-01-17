
public class Terrain extends CasePropriete {
	
	public int loyer;

    public int prix;

    public Quartier quartier;

    public etatCasePropriete etatCasePropriete;
	
    // Constructeur
	public Terrain(String name, int c_loyer, int c_prix, Quartier c_quartier, etatCasePropriete c_etatCasePropriete) {
		super(name);
		loyer = c_loyer;
		prix = c_prix;
		quartier = c_quartier;
		etatCasePropriete = c_etatCasePropriete;
	}

    public void debiter(final Joueur j, float aPayer) {
    	j.solde -= aPayer;
    	System.out.println("Nouveau solde de " + j.nom + " --> " + j.solde);
    }

    public boolean payerLoyer(final Joueur j) {
    	if(etatCasePropriete.proprietaire.nom != j.nom && etatCasePropriete.debitable) {
    		float aPayer = (loyer + etatCasePropriete.batiment*30)*quartier.modifLoyer(j);
    		if(j.possedeSolde(aPayer)) {
    			System.out.println("Paiement d'un loyer de " + aPayer + " de " + j.nom + " a " + etatCasePropriete.proprietaire.nom);
        		debiter(j, aPayer);
        		etatCasePropriete.proprietaire.crediter(aPayer);
        		return true;
    		}
    		else {
    			return false;
    		}

    	}
    	return true;
    }

    public boolean atterrirSurCase(final Joueur j) {
    	payerLoyer(j);
    	if(etatCasePropriete.debitable) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean construire(final Joueur j) {
    	if(j.possedeSolde(50) && etatCasePropriete.proprietaire.nom == j.nom && quartier.estProprietaire(j)) {
    		debiter(j, 50);
    		etatCasePropriete.batiment += 1;
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean achat(Joueur j) {
    	if(j.possedeSolde(prix) && etatCasePropriete.proprietaire.nom != j.nom && !etatCasePropriete.debitable) {
    		debiter(j, prix);
    		etatCasePropriete.debitable = true;
    		etatCasePropriete.proprietaire = j;
    		quartier.proprietaires.add(j);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean estConstructible(Joueur j) {
        return quartier.estProprietaire(j);
    }
}
