package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.Lotto;
import main.Titolo;

public class LottoTest {
	@Test
	public void calculateLottoValue() throws Exception {
		Titolo titolo = new Titolo("XYZ", 10.1);
		Lotto lotto = new Lotto(titolo, 15);
		assertEquals(151.5, lotto.valore(), 0.0001);
	}
}
