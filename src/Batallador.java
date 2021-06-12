import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Batallador {
	
	private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();
	
	public void agregarArista(String inicio, String destino, int peso) {
		if(!vertices.containsKey(inicio)) {
			Vertice nuevoVertice = new Vertice(inicio);
			vertices.put(inicio, nuevoVertice);
		}
		if(!vertices.containsKey(destino)) {
			Vertice nuevoDestino = new Vertice(destino);
			vertices.put(destino, nuevoDestino);
		}
		vertices.get(inicio).agregarArista(new Camino(vertices.get(destino),peso));
	}
	
	
	
	@Override
	public String toString() {
		String res = vertices.keySet().toString() + "\n";
		for(Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			res += vertice.getKey() + " : " ;
			res += vertice.getValue().toString() + "\n" ;
		}
		return res;
	}
	
	public List<String> ordenamientoTopologico() throws GrafoExcepcion {
		Queue<Vertice> cola = new LinkedList<Vertice>();
		List<String> res = new LinkedList<String>();
		HashMap<String, Integer> gradosDeEntrada = calcularGradoDeEntrada(vertices);
		
		
		
		for(Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			if(gradosDeEntrada.get(vertice.getKey()) == 0 ) {
				cola.add(vertice.getValue());
			}
		}
		while(!cola.isEmpty()) {
			Vertice v = cola.poll();
			res.add(v.getNombre());
			for(Map.Entry<String, Camino> arista : v.getListaDeAristas().entrySet()) {
				gradosDeEntrada.put(arista.getKey(), gradosDeEntrada.get(arista.getValue().getVerticeDestino().getNombre())-1);
				if(gradosDeEntrada.get(arista.getValue().getVerticeDestino().getNombre()) == 0) {
					cola.add(arista.getValue().getVerticeDestino());
				}
			}
		}
		
		if(res.size() != vertices.size()) {
			throw new GrafoExcepcion("No se puede calcular el orden topologico porque el grafo tiene ciclos");
		}
		return res;
	}

	private HashMap<String, Integer> calcularGradoDeEntrada(HashMap<String, Vertice> vertices) {
		HashMap<String, Integer> gradosEntradaVertice = new HashMap<>();
		for (Map.Entry<String, Vertice> vertice: vertices.entrySet()) {
			if (!gradosEntradaVertice.containsKey(vertice.getKey())) {
				gradosEntradaVertice.put(vertice.getKey(), 0);
			}
			for (Map.Entry<String, Camino> arista : vertice.getValue().getListaDeAristas().entrySet()) {
				int grado = 1;
				if (gradosEntradaVertice.containsKey(arista.getValue().getVerticeDestino().getNombre())) {
					grado = gradosEntradaVertice.get(arista.getValue().getVerticeDestino().getNombre()) + 1;
				}
				gradosEntradaVertice.put(arista.getValue().getVerticeDestino().getNombre(), grado);
			}
		}
		return gradosEntradaVertice;
	}

	public static void main(String[] args) throws GrafoExcepcion {
		Batallador grafo = new Batallador();
		grafo.agregarArista("V0", "V1", 1);
		grafo.agregarArista("V0", "V2", 2);
		grafo.agregarArista("V1", "V3", 3);
		grafo.agregarArista("V2", "V4", 3);
		grafo.agregarArista("V3", "V5", 4);
		grafo.agregarArista("V4", "V5", 4);
		System.out.println(grafo);
		
		System.out.println(grafo.ordenamientoTopologico());
	}
}
