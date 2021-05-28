import org.junit.Test;
import org.junit.Assert;


public class TestRadaiteran {

	@Test
	public void pruebaRadaiteran001() {
		Raza A = new Radaiteran();
	}	
	
	Raza A = new Radaiteran();
	
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
		Raza dummyStrike = new Hyur();
		A.atacar(dummyStrike);
		Assert.assertEquals(44, dummyStrike.getVTActual());

	}
	
}
