
public class Radaiteran extends Raza {

	private int cantAtaquesDados = 0;

	public Radaiteran(Alianza alianza) {
		super(56, 36, alianza);

	}

	@Override
	public void atacar(Guerrero enemigo) {
		enemigo.recibirDanio(danioBasico + (3 * cantAtaquesDados));
		this.cantAtaquesDados++;
	}

	public int getCantAtaquesDados() {
		return this.cantAtaquesDados;
	}

}
