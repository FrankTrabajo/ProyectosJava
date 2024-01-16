package lagunaJuego;

import java.util.List;
import java.util.Scanner;

import lagunaJuego.Heroes.Heroe;
import lagunaJuego.Monstruos.Monstruos;

public class MapaDeJuego {

	int dado1;
	int dado2;
	int dañoAPersonaje;
	int turno = 1;
	int cont = 0;
	Heroe heroes;
	Monstruos bestias;
	private static Scanner sc = new Scanner(System.in);
	
	public MapaDeJuego(Heroe heroes, Monstruos bestias) {
		super();
		this.heroes = heroes;
		this.bestias = bestias;
	}
	
	
	//Opcion de elegir personaje
	public void menuDePersonajes() {
		System.out.println("Este es el menu de personajes, aqui tendras que elegir entre Arquero, Guerrero o Mago");
		System.out.println("Cual eliges?");
	}
	
	
	//Presentacion por elegir personaje
	public void seleccionDelPersonaje(String tipoPersonaje) {
		
		System.out.println("Has elegido ser " + tipoPersonaje + " sabia eleccion");
		
		if(tipoPersonaje.equalsIgnoreCase("Arquero")) {
			System.out.println("Los arqueros son muy habiles a la hora de luchar, pueden hasta atacar dos veces por turno");
		} else if(tipoPersonaje.equalsIgnoreCase("Guerrero")) {
			System.out.println("Los guerreros son unos grandes, nobles y fuertes caballeros con gran armadura y mucha vida");
		} else if(tipoPersonaje.equalsIgnoreCase("Mago")) {
			System.out.println("Los magos provienen de una antigua civilizacion, pueden lanzar muchos hechizos y tienen mucho daño");
		}

	}
	
	//En el mapa tendremos que meter 3 enemigos y 1 solo heroe
	
	public void comienzoDelJuego(Heroe h, Monstruos m1, Monstruos m2, Monstruos m3) {
		
		
		
	}
	
	
	//En el juego habra un mapa en el que tengas que pasar por 5 salas,
	//La primera sala sera la primera lucha contra un esbirro
	//La seguna sala será para recuperar vida, habra que acertar un acertijo
	//En la siguiente sala lucharas contra un esbirro de alto nivel
	//En la cuarta sala otro acertijo para recuperar vida
	//En la ultima sala encontraremos al jefe
	//La lista de heroes de momento es por si lo amplio para meter mas personas
	//Dependiendo de las personas que haya, se añadiran mas enemigos
	//Metodo de batalla:
	
	
	
}