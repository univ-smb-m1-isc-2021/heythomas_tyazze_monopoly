package test.java;
import static org.junit.jupiter.api.Assertions.*;
import main.java.Kase;

import org.junit.jupiter.api.Test;

public class testCase {
	@Test
    void suivant() {

        Kase premKase = new Kase("test1");
        Kase secdKase = new Kase("test2");

        premKase.suivant = secdKase;

        assertTrue(premKase.suivant().equals(secdKase));
    }
}
