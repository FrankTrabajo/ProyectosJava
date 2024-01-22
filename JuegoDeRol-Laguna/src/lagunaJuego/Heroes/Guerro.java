package lagunaJuego.Heroes;

import java.util.Scanner;

public class Guerro extends Heroe{

	private static Scanner sc = new Scanner(System.in);
	
	String nombre;
	String tipo = "Guerrero";
	int vida = 500;
	int armadura = 150;
	int mana = 70;
	int ataque = 80;
	
	
	public Guerro(String nombre, String tipo, int vida, int armadura, int mana, int ataque) {
		super(nombre, tipo);
		
	}
	
	@Override
	public void presentacion() {
		System.out.println("Soy " + nombre + " el guerrero, preparado para una paliza");
	}
	
	public int menuAtaque() {
		System.out.println("¿Que tipo de ataque deseas hacer?");
		System.out.println("1. Ataque normal -30 mana");
		System.out.println("2. Martillazo -55 mana ");
		int opcion = sc.nextInt();
		int damage = 0;
		switch(opcion) {
		case 1:
			damage = ataqueNormal();
		break;
		case 2:
			damage = ataqueMartillazo();
		break;
		}
		return damage;
	}
	
	public int ataqueNormal() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dado1 = (int) (Math.random()*12+1);
		
		if(mana < 30) {
			System.out.println("No tienes mana para atacar, te va a tocar esperar un turno");
		} else { mana -= 30; }
		if(dado1 == 6) {
			daño += dado1*2;
		}
		
		return daño;
	}
	
	public int ataqueMartillazo() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dadoUno = (int) (Math.random()*12+1);
		int dadoDos = (int) (Math.random()*12+1);
		if(mana < 55) {
			System.out.println("No tienes mana para atacar, te va a tocar esperar un turno");
		} else { mana -= 55; } 
		
		daño = dadoUno + dadoDos;
		
		return daño;
	}

	//El guerrero solo puede tirar un dado, dependiendo del numero que salga hara mas daño o no
	//Tiene mas armadura que ninguno, tiene mas vida, pero tiene menos mana que ninguno
	
}
