import java.util.*;

//Acá está el composite.
public class Ejercito extends Guerrero {

	PriorityQueue<Guerrero> tropas = new PriorityQueue<Guerrero>();

	public Ejercito(Alianza alianza) {
		super(0, alianza);
		

	}

	public void agregarGuerrero(Guerrero guerrero) {
		tropas.add(guerrero);
	}

	@Override
	public void atacar(Guerrero enemigo) {
		Guerrero tropaActual = tropas.poll();
		tropaActual.atacar(enemigo);
		tropas.add(tropaActual);
	}

	@Override
	public void descansar() {

		PriorityQueue<Guerrero> tropasDescansadas = new PriorityQueue<Guerrero>();

		while (tropas.isEmpty()) {
			Guerrero temporal = tropas.poll();
			temporal.descansar();
			tropasDescansadas.add(temporal);
		}
		tropas = tropasDescansadas;
	}

	@Override
	public int getVTActual() {
		int VTEjercito = 0;

		for (Guerrero guerreroActual : tropas) {
			VTEjercito += guerreroActual.getVTActual();
		}

		return VTEjercito;
	}

	public void recibirDanio(int danio) {
		Guerrero tropaActual = tropas.poll();
		tropaActual.recibirDanio(danio);
		if(tropaActual.getVTActual() > 0) {
			tropas.add(tropaActual);
		}
	}

}
