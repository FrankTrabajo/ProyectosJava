package elSeniorDelLosAnillos;

public class Hobbit extends Heroes {

	public Hobbit(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void presentacion() {
		System.out.println("Soy un hobbit");
	}

}

