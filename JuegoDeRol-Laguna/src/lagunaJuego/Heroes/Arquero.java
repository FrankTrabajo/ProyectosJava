package lagunaJuego.Heroes;

import java.util.Scanner;

public class Arquero extends Heroe{

	private static Scanner sc = new Scanner(System.in);
	
	String nombre;

	int vida = 300;
	int armadura = 50;
	int mana = 100;
	int ataque = 40;
	
	public Arquero(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void presentacion() {
		System.out.println("Mi nombre es " + nombre + " y con mi flecha acabare contigo");
	}
	//Los arqueros son agiles son capaces de lanzar hasta 2 ataques a la vez, el segundo mas debil que el primero
	//La armadura que tienen es menor que el guerrero pero mayor al mago
	//El mana es bajo al mago y mayor al guerrero
	//El mana se va recuperando poco a poco en cada rona
	
	//El arquero tiene 300hp
	
	
	public int menuAtaque() {
		System.out.println("¿Que tipo de ataque deseas hacer?");
		System.out.println("1. Ataque normal -30 mana");
		System.out.println("2. Flecha doble -55 mana ");
		int opcion = sc.nextInt();
		int damage = 0;
		switch(opcion) {
		case 1:
			damage = ataqueNormal();
		break;
		case 2:
			damage = ataqueFlechaDoble();
		break;
		}
		return damage;
	}
	
	public int ataqueNormal() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dado1 = (int) (Math.random()*12+1);
		
		if(dado1 % 2 == 0) {
			daño += dado1;
		}
		mana -= 30;
		return daño;
	}
	
	public int ataqueFlechaDoble() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dadoUno = (int) (Math.random()*12+1);
		int dadoDos = (int) (Math.random()*12+1);
		
		daño = dadoUno + dadoDos;
		mana -= 55;
		return daño;
	}
	

}
