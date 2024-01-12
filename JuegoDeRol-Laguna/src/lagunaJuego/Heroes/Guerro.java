package lagunaJuego.Heroes;

public class Guerro extends Heroe{

	String nombre;
	String tipo = "Guerrero";
	int vida = 500;
	int armadura = 150;
	int mana = 70;
	int ataque = 80;
	
	
	public Guerro(String nombre, String tipo, int vida, int armadura, int mana, int ataque) {
		super(nombre, tipo, vida, armadura, mana, ataque);
		
	}

	//El guerrero solo puede tirar un dado, dependiendo del numero que salga hara mas daño o no
	//Tiene mas armadura que ninguno, tiene mas vida, pero tiene menos mana que ninguno
	
}
