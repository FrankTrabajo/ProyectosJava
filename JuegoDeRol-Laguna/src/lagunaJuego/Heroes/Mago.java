package lagunaJuego.Heroes;

public class Mago extends Heroe {

	String nombre;
	String tipo = "Mago";
	int vida = 250;
	int armadura = 30;
	int mana = 200;
	int ataque = 60;
	
	public Mago(String nombre, String tipo, int vida, int armadura, int mana, int ataque) {
		super(nombre, tipo, vida, armadura, mana, ataque);
		
	}

	//El mago tiene mas daño que ninguno, pero tiene menos posibilidad de asertar un buen golpe
	//El mago tiene menos vida y menos armadura que ninguno pero tiene mas mana
	
}
