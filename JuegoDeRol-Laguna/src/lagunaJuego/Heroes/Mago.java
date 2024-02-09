package lagunaJuego.Heroes;

import java.util.Scanner;

public class Mago extends Heroe {

	private static Scanner sc = new Scanner(System.in);
	
	String nombre;
	int vida = 250;
	int armadura = 30;
	int mana = 200;
	int ataque = 60;
	
	public Mago(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void presentacion() {
		System.out.println("Soy " + this.nombre + " el Viejo Mago");
	}
	
	@Override
	public int menuAtaque() {
		System.out.println("¿Que tipo de ataque deseas hacer?");
		System.out.println("1. Ataque normal -30 mana");
		System.out.println("2. Bola de fuego -80 mana ");
		int opcion = sc.nextInt();
		int damage = 0;
		switch(opcion) {
		case 1:
			damage = ataqueNormal();
		break;
		case 2:
			damage = ataqueBolaDeFuego();
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
			daño = 0;
		} else { 
			mana -= 30;
			if(dado1 % 2 == 0) {
				daño += dado1;
			}
		}
		
		return daño;
	}
	
	public int ataqueBolaDeFuego() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dadoUno = (int) (Math.random()*12+1);
		int dadoDos = (int) (Math.random()*12+1);
		System.out.println("dado1 :" + dadoUno + " dado2: " + dadoDos);
		if(mana < 80) {
			System.out.println("No tienes mana para atacar, te va a tocar esperar un turno");
			daño = 0;
		} else { 
			mana -= 80;
			if(dadoUno == dadoDos) {
				daño = daño * 2;
			}
			else if ((dadoUno + dadoDos) % 2 == 0) {
				daño = daño + (dadoUno + dadoDos)*2;
			}
			else {
				daño = daño + (dadoUno + dadoDos);
			}
		} 

		return daño;
	}

	@Override
	public String toString() {
		return "Mago [nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + ", mana=" + mana + ", ataque="
				+ ataque + "]";
	}

	
	
	//El mago tiene mas daño que ninguno, pero tiene menos posibilidad de asertar un buen golpe
	//El mago tiene menos vida y menos armadura que ninguno pero tiene mas mana
	
}
