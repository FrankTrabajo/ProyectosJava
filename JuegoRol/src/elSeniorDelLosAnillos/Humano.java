package elSeniorDelLosAnillos;

public class Humano extends Heroes{

	public Humano(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void presentacion() {
		System.out.println("Soy un humano");
	}
	
}

