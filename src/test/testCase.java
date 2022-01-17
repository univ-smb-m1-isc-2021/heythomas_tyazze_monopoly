package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Kase;

public class testCase {
	@Test
    void suivant() {

        Kase premKase = new Kase("test1");
        Kase secdKase = new Kase("test2");

        premKase.suivant = secdKase;

        assertTrue(premKase.suivant().equals(secdKase));
    }
}
