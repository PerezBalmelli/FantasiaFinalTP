
public abstract class Guerrero implements Comparable<Guerrero> {

	protected int VTActual;
	protected Alianza alianza;

	public Guerrero(int VT, Alianza alianza) {
		this.VTActual = VT;
		this.alianza = alianza;
	}

	public abstract void atacar(Guerrero enemigo);

	public abstract void descansar();

	public abstract void recibirDanio(int Danio);

	public int getVTActual() {
		return VTActual;
	}

	@Override
	// Comparador del priority queue de Ejercito
	public int compareTo(Guerrero otroGuerrero) {
		if (this.alianza.equals(otroGuerrero.alianza)) {
			return Integer.compare(getVTActual(), otroGuerrero.getVTActual());
		}
		return this.alianza.compareTo(otroGuerrero.alianza);
	}
}
