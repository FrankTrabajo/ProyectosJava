package elSeniorDelLosAnillos;

public class Trasgos extends Bestias{

	public Trasgos(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void presentacion() {
		System.out.println("Soy un trasgo");
	}
}

