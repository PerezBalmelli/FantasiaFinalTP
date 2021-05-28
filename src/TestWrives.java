import org.junit.Test;
import org.junit.Assert;

public class TestWrives {
	

	@Test
	public void seCreaUnWriveConSalud108() {
		Raza wrives = new Wrives();
		Assert.assertEquals(108, wrives.getVT());
	}

	@Test
	public void seCreaUnWriveConDanio113() {
		Raza wrives = new Wrives();
		Assert.assertEquals(113, wrives.getDanioBasico());

	}

	

	@Test
	public void unUnWrivesEnElPrimerAtaqueCausaUnDanioNormal() {

		Raza wrives = new Wrives();
		Raza hyur = new Hyur(); // salud inicial = 300

		wrives.atacar(hyur); // causa un danio de 113

		Assert.assertEquals(187, hyur.getVT());

	}

	@Test
	public void unUnWriveNoAtacaPorqueNoEsSuTurno() {
		Raza wrives = new Wrives();
		Raza hyur1 = new Hyur(); // salud inicial = 300

		
		wrives.atacar(hyur1); // causa un danio de 113
		wrives.atacar(hyur1); // no ataca por segunda vez porque no es su turno.

		Assert.assertFalse(wrives.getTurno());

	}

	@Test
	public void unUnWrivesEnElSegundoAtaqueCausaUnDanioDoble() {

		Raza wrives = new Wrives();
		Raza hyur = new Hyur(); // salud inicial = 300

		hyur.atacar(wrives); // ataca primero, le saca 40 puntos de salud al
								// wrives
		wrives.atacar(hyur); // causa un danio de 113

		hyur.atacar(wrives); // ataca primero, le saca 40 puntos de salud al
		// wrives

		wrives.atacar(hyur); // causa un danio de 226

		Assert.assertEquals(0, hyur.getVT());

	}

	@Test
	public void AtacanAUnWrivesYLeCausaElDobleDeDanio() {
		Raza wrives = new Wrives(); // salud inicial de un Wrives = 108
		Raza hyur = new Hyur();

		hyur.atacar(wrives); // le saca 40 puntos de salud al wrives

		Assert.assertEquals(68, wrives.getVT());

	}
	
	@Test
	public void unWriveDescansa(){
		Wrives wrives = new Wrives(); 
		wrives.descansar();
		
		Assert.assertTrue(wrives.getHuboDescanso());
	}
	
	
	@Test
	public void cuandoUnWriveDescansaElContadorDeAtaqueQuedanEn0(){
		Wrives wrives = new Wrives(); 
		wrives.descansar();
		
		Assert.assertEquals(0, wrives.getContadorDeAtaques());
		
	}
	
	@Test
	public void unWrivesAtacaLuegoDeDescansar(){
		Wrives wrives = new Wrives();
		Raza hyur = new Hyur();
		wrives.descansar();
		hyur.atacar(wrives); // ataca primero, le saca 40 puntos de salud al
		// wrives
		wrives.atacar(hyur); // causa un danio de 113
		
		Assert.assertEquals(187, hyur.getVT());
		
	}
	
	

}


