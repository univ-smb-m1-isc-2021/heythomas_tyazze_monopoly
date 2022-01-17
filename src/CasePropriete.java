
public class CasePropriete extends Kase {
	
    /*
     * Cette classe est generique, elle possede les comportements par defaut d'une case propriete
     * Dans les faits, cette classe n'est jamais utilisee, et est toujours reecrite pour un terrain par exemple
     */
	
    public CasePropriete(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public int loyer;

    public int prix;

    public Quartier quartier;

    public etatCasePropriete etatCasePropriete;

    public void debiter(final Joueur j) {
    }

    public boolean payerLoyer(final Joueur j) {
		return false;
    }

    public boolean atterrirSurCase(final Joueur j) {
    	return false;
    }

    public boolean construire(final Joueur j) {
    	return false;
    }
    
    public boolean achat(Joueur j) {
    	return false;
    }

    public boolean estLibre() {
        return !etatCasePropriete.debitable;
    }

    public boolean estConstructible(Joueur j) {
        // TODO Auto-generated return
        return false;
    }
}
