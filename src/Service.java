
public class Service extends CasePropriete {

	public int loyer;

    public int prix;

    public Quartier quartier;

    public etatCasePropriete etatCasePropriete;
	
    // Constructeur
	public Service(String name, int c_loyer, int c_prix, Quartier c_quartier, etatCasePropriete c_etatCasePropriete) {
		super(name);
		loyer = c_loyer;
		prix = c_prix;
		quartier = c_quartier;
		etatCasePropriete = c_etatCasePropriete;
	}

	// Debit du joueur courant
    public void debiter(final Joueur j, float aPayer) {
    	j.solde -= aPayer;
    	System.out.println("Nouveau Solde --> " + j.solde);
    }
    
    // Verification eligibilite et paiement loyer (selon les regles de la case service avec les des)
    public boolean payerLoyer(final Joueur j) {
    	if(etatCasePropriete.proprietaire.nom != j.nom && etatCasePropriete.debitable) {
    		
    		System.out.println("Lance de de pour les services");
    		De de = new De();
    		int mul = de.lancer();
    		
    		int num = 0;
    		
    		for(int i=0; i<quartier.proprietaires.size(); i++) {
    			if(quartier.proprietaires.get(i).nom == etatCasePropriete.proprietaire.nom) {
    				num++;
    			}
    		}
    		
    		float aPayer;
    		
    		switch (num) {
			case 1:
				aPayer = mul*4;
				break;
			case 2: 
				aPayer = mul*10;
				break;
			default:
				aPayer = 0;
			}

    		if(j.possedeSolde(aPayer)) {
        		debiter(j, aPayer);
        		etatCasePropriete.proprietaire.crediter(aPayer);
    		}
    		else {
    			j.finTour();
    		}

    	}
    	return true;
    }
    
    // Appele a la fin du deplacement du joueur
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
