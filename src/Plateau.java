import java.util.ArrayList;
import java.util.List;

public class Plateau {
    public List<Kase> cases = new ArrayList<Kase> ();

    public void genererCases() {
        for(int i = 0; i<cases.size()-1; i++){
            cases.get(i).suivant = cases.get(i+1);
            System.out.println("HEEEEEEEEEEEY");
        }
        cases.get(cases.size()).suivant = cases.get(0);
    }

}
