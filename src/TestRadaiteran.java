import org.junit.Test;
import org.junit.Assert;

public class TestRadaiteran {

	@Test
	public void pruebaRadaiteran001() {
		Radaiteran A = new Radaiteran(Alianza.PROPIO);
	}

	Radaiteran A = new Radaiteran(Alianza.PROPIO);

	@Test
	public void pruebaRadaiteran002() {
		Assert.assertEquals(36, A.getVTMax());
	}

	@Test
	public void pruebaRadaiteran003() {
		Assert.assertEquals(56, A.getDanioBasico());
	}

	@Test
	public void pruebaRadaiteran004() {
		Raza dummyStrike = new Hyur(Alianza.ENEMIGO);
		A.atacar(dummyStrike);
		Assert.assertEquals(244, dummyStrike.getVTActual());
		Assert.assertEquals(1, A.getCantAtaquesDados());
	}

	@Test
	public void pruebaRadaiteran005() {

	}

}
