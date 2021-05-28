
public class Nortaichian extends Raza {

	boolean puedeAtacar;
	
	public Nortaichian(){
		super(18, 66);
		puedeAtacar = true;
	}
	
	@Override
	public void atacar(Raza enemigo){
		
		if(puedeAtacar){
			super.atacar(enemigo);
			Double puntosACurar = super.getVTActual()*0.04;
			super.aumentarVT(puntosACurar.intValue());
		} else{
			System.out.println("No puede atacar durante x turnos");			
		}
		
	}
	
	@Override
	public void recibirDanio(int danio){
		if(!puedeAtacar){
			danio = danio/2;
		}
		super.reducirVT(danio);
		super.modificarDanioBasico(getDanioBasico()*2);
	}
	
	@Override
	public void descansar(){
		super.aumentarVT(getVTMax());
		puedeAtacar=false;
	}
}
