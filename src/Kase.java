public class Kase {
    public Kase suivant;
    
    public String nom;

    public Kase suivant() {
        return suivant;
    }

    public void atterrirSurCase(final Joueur j) {
    }

    public boolean estLibre() {
        // TODO Auto-generated return
        return false;
    }

    public boolean estConstructible() {
        // TODO Auto-generated return
        return false;
    }

    public void achat() {
    }
    
    public Kase(String name) {
    	nom = name;
    }
}
