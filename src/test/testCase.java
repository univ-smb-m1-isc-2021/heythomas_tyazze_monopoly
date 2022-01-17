package test;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class testCase {
	@Test
    void suivant() {

        Kase premKase = new Kase();
        Kase secdKase = new Kase();

        premKase.suivant = secdKase;

        assertThat(premKase.suivant())
                .isEqualTo(secdKase);
    }
}
