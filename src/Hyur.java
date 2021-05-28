class Hyur extends Raza {

	public Hyur() {
		super(20, 300);
	}

	@Override
	public void atacar(Raza enemigo) {
		super.atacar(enemigo);
		System.out.println("Hyur ataca a guerrero enemigo.");
	}

}
