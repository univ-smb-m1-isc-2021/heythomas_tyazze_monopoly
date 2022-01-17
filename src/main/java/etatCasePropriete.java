package main.java;

public class etatCasePropriete {
    public Joueur proprietaire;
    public boolean debitable;
    public int batiment;
    
    public etatCasePropriete() {
    	proprietaire = new Joueur("NULL");
        debitable = false;
        batiment = 0;
	}
}
