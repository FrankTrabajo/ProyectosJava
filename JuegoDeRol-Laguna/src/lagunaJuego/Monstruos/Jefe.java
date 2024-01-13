package lagunaJuego.Monstruos;

public class Jefe extends Monstruos{

	String nombre;
	String tipo = "Jefe";
	int vida = 1000;
	int armadura = 45;
	int mana = 200;
	int ataque = 230;
	
	public Jefe(String nombre, String tipo, int vida, int armadura, int mana, int daño) {
		super(nombre, tipo, vida, armadura, mana, daño);

	}
	
	@Override
	public void presentacion() {
		System.out.println("¿Quien se atreve a combatir contra " + nombre + 
				" el demonio negro");
	}
	
	//Tiene mas vida que ningun otro personaje del juego
	//Tiene mas daño que nadie
	//Tiene mas mana
	//Lo malo que tiene es que solo puede atacar 1 vez cada 2 turnos
	
	

}
