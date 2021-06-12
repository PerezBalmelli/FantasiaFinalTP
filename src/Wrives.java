public class Wrives extends Raza {

	private int cantidadDeAtaques; // En el segundo ataque lo hace con el doble
									// de danio
	private int ataquesRecibidos;
	private boolean huboDescanso;

	public Wrives(Alianza alianza) {
		super(113, 108, alianza);
	}

	@Override
	public void atacar(Guerrero enemigo) {

		if (huboDescanso) {

			huboDescanso = !(ataquesRecibidos > 0); // luego de un descanso,
													// ataca si lo atacan
													// primero.
		}

		if (!huboDescanso) {
			if (cantidadDeAtaques % 2 == 0) {
				super.atacar(enemigo);
				cantidadDeAtaques++;

			} else {
				super.atacar(enemigo); // si cantidadDeAtaques es impar
										// ataca x2
				super.atacar(enemigo);
				cantidadDeAtaques++;

			}

		}
	}

	@Override
	public void recibirDanio(int danio) { // siempre recibe danio x2
		super.recibirDanio(danio);
		super.recibirDanio(danio);
		this.ataquesRecibidos++;

	}

	@Override
	public void descansar() {
		super.aumentarVT(super.getVTActual() + 50);
		cantidadDeAtaques = 0;
		this.ataquesRecibidos = 0;
		huboDescanso = true;
	}

	// getters

	public boolean getHuboDescanso() {
		return huboDescanso;
	}

	public int getContadorDeAtaques() {
		return this.cantidadDeAtaques;
	}

	public String toString() {
		return "Wrives";
	}
}
