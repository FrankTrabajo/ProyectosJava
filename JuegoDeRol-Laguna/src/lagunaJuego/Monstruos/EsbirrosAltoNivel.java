package lagunaJuego.Monstruos;

import java.util.Scanner;

public class EsbirrosAltoNivel extends Monstruos {

	private static Scanner sc = new Scanner(System.in);
	
	String nombre = "Esbirro alto nivel";
	String tipo = "EsbirroAlto";
	int vida = 400;
	int armadura = 30;
	int mana = 50;
	int ataque = 50;
	
	@Override
	public void presentacion() {
		System.out.println("Este será tu fin asqueroso humano");
	}
	
	public int ataqueEsbirroAltoNivel() {
		int dado = (int) (Math.random()*12+1);
		int daño = 0;
		if(dado % 2 == 0) {
			daño = ataqueNormal();
		} else {
			daño = ataqueMaza();
		}
		return daño;
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
	
	public int ataqueMaza() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dadoUno = (int) (Math.random()*12+1);
		int dadoDos = (int) (Math.random()*12+1);
		if(mana < 40) {
			System.out.println("No tienes mana para atacar, te va a tocar esperar un turno");
			daño = 0;
		} else { 
			mana -= 60;
			daño = dadoUno + dadoDos;
		} 

		return daño;
	}
	

	// Los esbirros solo tienen una tirada de dados, dependiendo del numero tienen otra tirada mas
	// Tienen poco daño un poco mas que los esbirros normales y poca vida pero mas que los normales
	// Tienen poca mana pero mas que los normales

}
