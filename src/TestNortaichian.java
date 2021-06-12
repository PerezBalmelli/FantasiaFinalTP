import org.junit.Test;
import org.junit.Assert;

public class TestNortaichian {

	@Test
	public void seCreaUnNortaichian() {
		@SuppressWarnings("unused")
		Raza sujeto = new Nortaichian(Alianza.PROPIO);
	}

	Raza sujeto = new Nortaichian(Alianza.PROPIO);

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
		Raza hyur = new Hyur(Alianza.ENEMIGO);
		Assert.assertEquals(300, hyur.getVTActual());
		sujeto.atacar(hyur);
		Assert.assertEquals(282, hyur.getVTActual());

	}

	@Test
	public void elNortaichianAtacaYSeCuraUn4PorCientoDeSuSalud() {
		Raza hyur = new Hyur(Alianza.ENEMIGO);
		hyur.atacar(sujeto);
		Assert.assertEquals(46, sujeto.getVTActual());
		sujeto.atacar(hyur);
		Assert.assertEquals(47, sujeto.getVTActual());
	}

	@Test
	public void elNortaichanSeEnfureceYDuplicaSuDanio() {
		Raza hyur = new Hyur(Alianza.ENEMIGO);
		hyur.atacar(sujeto);
		sujeto.atacar(hyur);
		Assert.assertEquals(264, hyur.getVTActual());
	}

	@Test
	public void elNortaichanDescansaYSeVuelveDePiedra() {
		Raza hyur = new Hyur(Alianza.ENEMIGO);
		sujeto.descansar();
		sujeto.atacar(hyur);
		Assert.assertEquals(300, hyur.getVTActual());
		hyur.atacar(sujeto);
		Assert.assertEquals(56, sujeto.getVTActual());
	}

}
