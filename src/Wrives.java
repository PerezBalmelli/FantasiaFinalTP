public class Wrives extends Raza {

	private int cantidadDeAtaques; // En el segundo ataque lo hace con el doble
	private boolean huboDescanso; // de danio

	public Wrives() {
		super(113, 108);
	}

	@Override
	public void atacar(Raza enemigo) {

		if (huboDescanso || !super.esMiTurno) {
			System.err
					.println("No es el turno del guerrero Wrives o no hay necesidad de atacar.");
		} else {

			if (cantidadDeAtaques % 2 == 0) {
				super.atacar(enemigo);
				cantidadDeAtaques++;
				super.esMiTurno = false;
				System.out.println("El gerrero Wrives ataca utilizando magia.");

			} else {
				super.atacar(enemigo); // si cantidadDeAtaques es impar
										// ataca x2
				super.atacar(enemigo);
				cantidadDeAtaques++;
				super.esMiTurno = false;
				System.out
						.println("El gerrero Wrives ataca x2 utilizando magia.");
			}

		}
	}

	@Override
	public void recibirDanio(int danio) { //siempre recibe danio x2
		super.recibirDanio(danio);
		super.recibirDanio(danio);
		super.esMiTurno = true;

		if (huboDescanso) {
			huboDescanso = !super.esMiTurno; // se va el "efecto" del
		} // descanso cuando el
			// oponente ataca.
	}

	@Override
	public void descansar() {
		super.aumentarVT(super.getVTActual() + 50);
		super.esMiTurno = false;
		cantidadDeAtaques = 0;
		huboDescanso = true;
	}

	// getters

	public boolean getHuboDescanso() {
		return huboDescanso;
	}

	public int getContadorDeAtaques() {
		return this.cantidadDeAtaques;
	}

}
