package elSeniorDelLosAnillos;

public class Elfo extends Heroes {

	public Elfo(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void presentacion() {
		System.out.println("Soy un elfo");
	}
}

