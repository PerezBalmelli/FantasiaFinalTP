public class Camino {
	
	private Vertice verticeDestino;
	private double peso;
	
	public Camino(Vertice destino, double peso) {
		
		this.verticeDestino = destino;
		this.peso = peso;
		
	}

	public Vertice getVerticeDestino() {
		return verticeDestino;
	}

	public double getPeso() {
		return peso;
	}
	
}
