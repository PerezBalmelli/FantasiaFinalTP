import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Vertice {
	private HashMap<String, Camino> aristas = new HashMap<String, Camino>();
	private String nombre;
	
	public Vertice(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarArista(Camino arista) {
		aristas.put(arista.getVerticeDestino().nombre, arista);
	}

	public Map<String, Camino> getListaDeAristas() {
		return  Collections.unmodifiableMap(aristas);
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		String res = "";
		for(Map.Entry<String, Camino> arista : aristas.entrySet()) {
			res += "[" + arista.getValue().getVerticeDestino().nombre + ", " + arista.getValue().getPeso() + "] ";
		}
		return res;
	}
	
}
