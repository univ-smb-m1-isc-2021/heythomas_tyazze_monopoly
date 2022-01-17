package main;
import java.util.Scanner;

public class De {
	// Lancer de de "faux" qui permet de choisir la valeur obtenue
    public int lancer() {
        @SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
        System.out.println("Quel est le resultat du de ?");
        int result = scn.nextInt();
        // scn.close();
		return result;
    }

}
