import java.util.ArrayList;
import java.util.List;

public class Plateau {
    public List<Kase> cases = new ArrayList<Kase> ();

    public void genererCases() {
        for(int i = 0; i<cases.size()-1; i++){
            cases.get(i).suivant = cases.get(i+1);
        }
        cases.get(cases.size()-1).suivant = cases.get(0);
    }

}
