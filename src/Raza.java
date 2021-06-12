
public abstract class Raza extends Guerrero {

	protected int danioBasico;
	protected Alianza alianza;
	private int VTMax;

	/**
	 * @param danioBasico
	 * @param vT
	 */
	public Raza(int danioBasico, int VTMax, Alianza alianza) {
		super(VTMax, alianza);
		this.danioBasico = danioBasico;
		this.VTMax = VTMax;
		this.alianza = alianza;
	}

	public int getVTMax() {
		return VTMax;
	}

	public int getDanioBasico() {
		return danioBasico;
	}

	public void atacar(Guerrero enemigo) {

		enemigo.recibirDanio(danioBasico);

	}

	public void recibirDanio(int danio) {
		reducirVT(danio);

	}

	public void descansar() {

	}

	public int getVT() {
		return VTActual;

	}

	protected void reducirVT(int cambioVT) {
		VTActual = VTActual - cambioVT;

		if (VTActual < 0) {
			VTActual = 0;
		}
	}

	protected void aumentarVT(int cambioVT) {
		// TODO Modificar
		VTActual += cambioVT;

		if (VTActual > VTMax) {
			VTActual = VTMax;
		}
	}

	protected void modificarDanioBasico(int cambioDanioBasico) {
		// TODO Releer consigna
		this.danioBasico = cambioDanioBasico;
	}

	public boolean estaHerido() {
		return VTActual < VTMax;
	}

}
