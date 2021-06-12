public class Reralopes extends Raza {
	private int contadorAtaques = 1;
	private boolean concentrado = true;
	private int contadorConcentracion = 0;

	public Reralopes(Alianza alianza) {
		super(27, 53, alianza);
	}

	@Override
	public void atacar(Guerrero enemigo) {

		if (contadorAtaques % 2 == 1) {
			if (concentrado && contadorConcentracion < 3) {

				enemigo.recibirDanio(danioBasico * 2);
			} else {
				enemigo.recibirDanio(danioBasico);

			}
		}
		contadorConcentracion++;
		contadorAtaques++;

	}

	@Override
	public void recibirDanio(int danio) {
		reducirVT(danio);
		concentrado = false;
	}

	@Override
	public void descansar() {
		concentrado = true;
		contadorConcentracion = 0;
	}

	public boolean getConcentrado() {
		return concentrado;
	}
}