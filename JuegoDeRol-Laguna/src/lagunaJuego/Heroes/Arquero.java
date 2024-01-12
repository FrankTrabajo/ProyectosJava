package lagunaJuego.Heroes;

public class Arquero extends Heroe{

	String nombre;
	String tipo = "Arquero";
	int vida = 300;
	int armadura = 50;
	int mana = 100;
	int ataque = 40;
	
	public Arquero(String nombre, String tipo, int vida, int armadura, int mana, int ataque) {
		super(nombre, tipo, vida, armadura, mana, ataque);
		
	}
	
	//Los arqueros son agiles son capaces de lanzar hasta 2 ataques a la vez, el segundo mas debil que el primero
	//La armadura que tienen es menor que el guerrero pero mayor al mago
	//El mana es bajo al mago y mayor al guerrero
	//El mana se va recuperando poco a poco en cada rona
	
	//El arquero tiene 300hp
	
	

}
