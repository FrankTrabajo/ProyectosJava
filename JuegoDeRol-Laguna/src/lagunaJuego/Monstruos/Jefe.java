package lagunaJuego.Monstruos;

public class Jefe extends Monstruos{

	String nombre = "El Gran";
	String tipo = "Jefe";
	int vida = 1000;
	int armadura = 45;
	int mana = 200;
	int ataque = 230;
	
	
	@Override
	public void presentacion() {
		System.out.println("¿Quien se atreve a combatir contra " + nombre + 
				" el demonio negro");
	}
	
	public int ataqueJefe() {
		int dado = (int) (Math.random()*12+1);
		int daño = 0;
		if(dado % 2 == 0) {
			daño = ataqueNormal();
		} else {
			daño = garraVacio();
		}
		return daño;
	}
	
	public int ataqueNormal() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dado1 = (int) (Math.random()*12+1);
		
		if(mana < 60) {
			System.out.println("No tienes mana para atacar, te va a tocar esperar un turno");
			daño = 0;
		} else { 
			mana -= 60;
			if(dado1 % 2 == 0) {
				daño += dado1*20;
			}
		}
		
		return daño;
	}
	
	public int garraVacio() {
		//Sera un dado de 12 caras, si sale par hace el daño normal mas el numero que haya sacado
		//Si sale impar solo hacer el daño de ataque normal
		int daño = ataque;
		int dadoUno = (int) (Math.random()*12+1);
		int dadoDos = (int) (Math.random()*12+1);
		if(mana < 90) {
			System.out.println("No tienes mana para atacar, te va a tocar esperar un turno");
			daño = 0;
		} else { 
			mana -= 90;
			daño = (dadoUno*dadoDos);
		} 

		return daño;
	}
	
	
	//Tiene mas vida que ningun otro personaje del juego
	//Tiene mas daño que nadie
	//Tiene mas mana
	//Lo malo que tiene es que solo puede atacar 1 vez cada 2 turnos
	
	

}
