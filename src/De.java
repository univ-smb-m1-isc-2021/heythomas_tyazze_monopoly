import java.util.Scanner;

public class De {
	// Lancer de d� "faux" qui permet de choisir la valeur obtenue
    public int lancer() {
        @SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
        System.out.println("Quel est le r�sultat du d� ?");
        int result = scn.nextInt();
        // scn.close();
		return result;
    }

}
