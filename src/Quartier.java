import java.util.*;

public class Quartier {
	public String nom;
    public float modificateurLoyer;
    public int quartierComplet;
    public List<Joueur> proprietaires = new ArrayList<Joueur> ();
    
    public Quartier(String c_nom, float c_modificateurLoyer, int c_quartierComplet) {
    	nom = c_nom;
    	modificateurLoyer = c_modificateurLoyer;
    	quartierComplet = c_quartierComplet;
    }
    
    // Application d'un modificateur de loyer, uniquement pour les terrains
    public float modifLoyer(Joueur j) {
    	if(proprietaires.size() == quartierComplet) {
    		if(proprietaires.get(0).nom == proprietaires.get(1).nom && quartierComplet == 2) {
    			return modificateurLoyer;
    		}
    		else if(proprietaires.get(0).nom == proprietaires.get(1).nom && proprietaires.get(1).nom == proprietaires.get(2).nom) {
    			return modificateurLoyer;
    		}
    		else {
    			return 1;
    		}
    	}
    	return 1;
    }
    
    // Méthode permettant rapidement de savoir si un joueur est proprietaire du quartier complet
    public boolean estProprietaire(Joueur j) {
    	if(proprietaires.size() == quartierComplet) {
    		if(proprietaires.get(0).nom == proprietaires.get(1).nom && quartierComplet == 2) {
    			return true;
    		}
    		else if(proprietaires.get(0).nom == proprietaires.get(1).nom && proprietaires.get(1).nom == proprietaires.get(2).nom && proprietaires.get(1).nom == j.nom) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	return false;
    }

}
