
public class Gare extends CasePropriete {

	public int loyer;

    public int prix;

    public Quartier quartier;

    public etatCasePropriete etatCasePropriete;
	
    // Constructeur
	public Gare(String name, int c_loyer, int c_prix, Quartier c_quartier, etatCasePropriete c_etatCasePropriete) {
		super(name);
		loyer = c_loyer;
		prix = c_prix;
		quartier = c_quartier;
		etatCasePropriete = c_etatCasePropriete;
	}
	
	// D�bit du joueur courant
    public void debiter(final Joueur j, float aPayer) {
    	j.solde -= aPayer;
    	System.out.println("Nouveau Solde --> " + j.solde);
    }
    
    // Verification eligibilit� et paiement loyer (selon les r�gles de la gare)
    public boolean payerLoyer(final Joueur j) {
    	if(etatCasePropriete.proprietaire.nom != j.nom && etatCasePropriete.debitable) {
    		int num = 0;
    		
    		for(int i=0; i<quartier.proprietaires.size(); i++) {
    			if(quartier.proprietaires.get(i).nom == etatCasePropriete.proprietaire.nom) {
    				num++;
    			}
    		}
    		
    		float aPayer;
    		
    		switch (num) {
			case 1:
				aPayer = 25;
				break;
			case 2: 
				aPayer = 50;
				break;
			case 3:
				aPayer = 100;
				break;
			case 4:
				aPayer = 200;
				break;
			default:
				aPayer = 0;
			}

    		if(j.possedeSolde(aPayer)) {
        		debiter(j, aPayer);
        		etatCasePropriete.proprietaire.crediter(aPayer);
        		return true;
    		}
    		else {
    			j.finTour();
    			return false;
    		}
    	}

		return true;
    }
    
    // Appel� a la fin du d�placement du joueur
    public boolean atterrirSurCase(final Joueur j) {
    	payerLoyer(j);
    	if(etatCasePropriete.debitable) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    // Verification et achat de la case
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
}
