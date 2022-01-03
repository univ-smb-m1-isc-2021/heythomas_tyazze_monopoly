import java.util.Scanner;

public class De {
    public int lancer() {
        @SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
        System.out.println("Quel est le résultat du dé ?");
        int result = scn.nextInt();
        // scn.close();
		return result;
    }

}
