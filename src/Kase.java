public class Kase {
    public Kase suivant;
    
    public String nom;
    
    /*
     * Cette classe est g�n�rique, elle poss�de les comportements par d�faut d'une case
     * Non achetable, sans loyer ni r�le, les classes Terrain/Gare/Service reecrivent ces m�thodes "vides"
     */

    public Kase suivant() {
        return suivant;
    }

    public boolean atterrirSurCase(final Joueur j) {
    	return true;
    }

    public boolean estLibre() {
        // TODO Auto-generated return
        return false;
    }

    public boolean estConstructible(Joueur j) {
        // TODO Auto-generated return
        return false;
    }

    public boolean achat(Joueur j) {
		return false;
    }
    public boolean construire(final Joueur j) {
    	return false;
    }
    
    public Kase(String name) {
    	nom = name;
    }
}
