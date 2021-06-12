import org.junit.Assert;
import org.junit.Test;

public class TestReralopes {

	Reralopes sujeto = new Reralopes(Alianza.PROPIO);
	Raza hyur = new Hyur(Alianza.ENEMIGO);
	
	//Prueba01
	@Test
	public void ElReralopeTiene53DeVitalidadInicial() {
		Assert.assertEquals(53, sujeto.getVTMax());
	}
	
	//Prueba02
	@Test
	public void ReralopeTiene27DeDanioBasico() {
		Assert.assertEquals(27, sujeto.getDanioBasico());
	}

	//Prueba03
	@Test
	public void ReralopeHace54DeDanioAlEstarConcentrado() {
		Assert.assertEquals(300, hyur.getVTActual());
		sujeto.atacar(hyur);
		Assert.assertEquals(246, hyur.getVTActual());

	}
	
	//Prueba04
	@Test
	public void ReralopePierdeConcentracionYHace27DeDanio() {
		Assert.assertEquals(300, hyur.getVTActual());
		hyur.atacar(sujeto);
		sujeto.atacar(hyur);
		Assert.assertEquals(273, hyur.getVTActual());

	}

	//Prueba05
	@Test
	public void ReralopePierdeConcentracionDescansaYLaRecupera() {
		hyur.atacar(sujeto);
		Assert.assertEquals(false, sujeto.getConcentrado());
		sujeto.descansar();
		Assert.assertEquals(true, sujeto.getConcentrado());
	}
	
	//Prueba06
	@Test
	public void HyurAtacaRarelopeYEsteRecibeDanio() {
		Assert.assertEquals(53, sujeto.getVTActual());
		hyur.atacar(sujeto);
		Assert.assertEquals(false, sujeto.getVTActual() == 53);
	}
}
