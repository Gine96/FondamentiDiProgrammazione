package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ArchivioCD;
import main.CD;

class ArchivioCDTest {

	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.getNumeroCd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andrè"));
		assertTrue(archivio.contiene("Anime salve"));
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andrè"));
		assertFalse(archivio.contiene("La buona novella"));
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.getNumeroCd());
		archivio.eliminaCD("Anime salve");
		assertEquals(1, archivio.getNumeroCd());
		assertFalse(archivio.contiene("Anime salve"));
	}

}
