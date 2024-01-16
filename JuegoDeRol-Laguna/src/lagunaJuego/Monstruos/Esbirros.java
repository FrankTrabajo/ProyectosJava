package lagunaJuego.Monstruos;

import java.util.Scanner;

public class Esbirros extends Monstruos {

	private static Scanner sc = new Scanner(System.in);
	
	String nombre;
	String tipo = "Esbirros";
	int vida = 200;
	int armadura = 10;
	int mana = 30;
	int ataque = 30;
	
	public Esbirros(String nombre, String tipo, int vida, int armadura, int mana, int ataque) {
		super(nombre, tipo, vida, armadura, mana, ataque);
		
	}
	
	@Override
	public void presentacion() {
		System.out.println("Acabare contigo!");
	}
	
	public int menuAtaque() {
		System.out.println("¿Que tipo de ataque deseas hacer?");
		System.out.println("1. Ataque normal -30 mana");
		System.out.println("2. Garrote -40 mana ");
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
		if(mana < 40) {
			System.out.println("No tienes mana para atacar, te va a tocar esperar un turno");
			daño = 0;
		} else { 
			mana -= 80;
			daño = dadoUno + dadoDos;
		} 

		return daño;
	}
	
	//Los esbirros solo tienen una tirada de dados
	//Tienen poco daño y poca vida
	//Tienen poca mana

}
