public abstract class Raza {

	protected int danioBasico;
	private int VTActual;
	private int VTMax;
	protected boolean esMiTurno = true;
	private boolean estaDesmayado = false;

	public Raza() {

	}

	/**
	 * @param danioBasico
	 * @param vT
	 */
	public Raza(int danioBasico, int VTMax) {
		this.danioBasico = danioBasico;
		this.VTMax = VTMax;
		this.VTActual = VTMax;
	}

	public int getVTActual() {
		return VTActual;
	}

	public int getVTMax() {
		return VTMax;
	}

	public int getDanioBasico() {
		return danioBasico;
	}

	public void atacar(Raza enemigo) {
		// TODO
		enemigo.recibirDanio(danioBasico);

	}

	protected void recibirDanio(int danio) {
		reducirVT(danio);

	}

	public void descansar() {
	}

	public int getVT() {
		return VTActual;

	}

	public boolean getTurno() {
		return esMiTurno;
	}

	protected void reducirVT(int cambioVT) {
		VTActual = VTActual - cambioVT;

		estaDesmayado = (VTActual <= 0);

		if (estaDesmayado) {
			VTActual = 0;
		}
	}

	protected void aumentarVT(int cambioVT) {
		VTActual += cambioVT;

		if (VTActual > VTMax) {
			VTActual -= VTActual - VTMax;
		}

	}

	protected void modificarDanioBasico(int cambioDanioBasico) {
		this.danioBasico = cambioDanioBasico;
	}

}
