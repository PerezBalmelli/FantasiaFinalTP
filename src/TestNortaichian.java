import org.junit.Test;
import org.junit.Assert;

public class TestNortaichian {

	@Test
	public void seCreaUnNortaichian() {
		@SuppressWarnings("unused")
		Raza sujeto = new Nortaichian();
	}

	Raza sujeto = new Nortaichian();

	@Test
	public void elNortaichianTiene66PuntosDeVidaMaxima() {
		Assert.assertEquals(66, sujeto.getVTMax());
	}

	@Test
	public void elNortaichianTiene18PuntosDeDanioBasico() {
		Assert.assertEquals(18, sujeto.getDanioBasico());
	}

	@Test
	public void elNortaichianHace18PuntosDeDanio() {
		Raza hyur = new Hyur();
		Assert.assertEquals(100, hyur.getVTActual());
		sujeto.atacar(hyur);
		Assert.assertEquals(82, hyur.getVTActual());

	}

	@Test
	public void elNortaichianAtacaYSeCuraUn4PorCientoDeSuSalud() {
		Raza hyur = new Hyur();
		hyur.atacar(sujeto);
		Assert.assertEquals(46, sujeto.getVTActual());
		sujeto.atacar(hyur);
		Assert.assertEquals(47, sujeto.getVTActual());
	}

	@Test
	public void elNortaichanSeEnfureceYDuplicaSuDanio() {
		Raza hyur = new Hyur();
		hyur.atacar(sujeto);
		sujeto.atacar(hyur);
		Assert.assertEquals(64, hyur.getVTActual());
	}

	@Test
	public void elNortaichanDescansaYSeVuelveDePiedra() {
		Raza hyur = new Hyur();
		sujeto.descansar();
		sujeto.atacar(hyur);
		Assert.assertEquals(100, hyur.getVTActual());
		hyur.atacar(sujeto);
		Assert.assertEquals(56, sujeto.getVTActual());
	}

}
