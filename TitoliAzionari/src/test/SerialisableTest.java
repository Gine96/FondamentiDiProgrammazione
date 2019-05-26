package test;

import org.junit.Test;

import main.Contenitore;
import main.ElencoTitoli;
import main.Lotto;
import main.Portafoglio;
import main.Titolo;
import  static org.junit.Assert.*;
import java.io.Serializable;

/**
 * Created by sam on 22/05/17.
 */
public class SerialisableTest {

	@Test
	public void isSerializable(){
		isSerializable(ElencoTitoli.class);
		isSerializable(Portafoglio.class);
		isSerializable(Titolo.class);
		isSerializable(Lotto.class);
		isSerializable(Contenitore.class);
	}

	private void isSerializable(Class t){
		assertTrue( t.getCanonicalName() + " do not implements Serializable", Serializable.class.isAssignableFrom(t));

	}

}
