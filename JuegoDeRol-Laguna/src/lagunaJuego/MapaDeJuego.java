package lagunaJuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lagunaJuego.Heroes.Arquero;
import lagunaJuego.Heroes.Guerrero;
import lagunaJuego.Heroes.Heroe;
import lagunaJuego.Heroes.Mago;
import lagunaJuego.Monstruos.Esbirros;
import lagunaJuego.Monstruos.EsbirrosAltoNivel;
import lagunaJuego.Monstruos.Jefe;
import lagunaJuego.Monstruos.Monstruos;

public class MapaDeJuego {

	int dado1;
	int dado2;
	int dañoAPersonaje;
	int turno = 1;
	int cont = 0;
	Heroe heroes;
	List<Monstruos> bestias;
	private static Scanner sc = new Scanner(System.in);
	
	
	
	//Presentacion por elegir personaje
	public Heroe seleccionDelPersonaje(String tipoPersonaje, String nombre) {
		
		System.out.println("Has elegido ser " + tipoPersonaje + " sabia eleccion");
		
		if(tipoPersonaje.equalsIgnoreCase("Arquero")) {
			Arquero jugadorArquero = new Arquero(nombre);
			heroes = jugadorArquero;
		} else if(tipoPersonaje.equalsIgnoreCase("Guerrero")) {
			Guerrero jugadorGuerrero = new Guerrero(nombre);
			heroes =  jugadorGuerrero;
		} else if(tipoPersonaje.equalsIgnoreCase("Mago")) {
			Mago jugadorMago = new Mago(nombre);
			heroes =  jugadorMago;
		}
		System.out.println("********************************");
		System.out.println("Creacion de personaje completada...");
		System.out.println("********************************");
		System.out.println("Que comience la ruta para acabar con el Jefe!");
		System.out.println("En los combates se te preguntara, si quieres hacer un ataque normal o uno especial");
		System.out.println("Los especiales consumen mana asique no te olvides de mantenerla");
		System.out.println("Por cada turno se regeneraran 10 de mana");
		return heroes;

	}
	
	//En el mapa tendremos que meter 3 enemigos y 1 solo heroe
	
	public void comienzoDelJuego(Heroe h, ArrayList<Monstruos> m) {
		
		ArrayList<Monstruos> ejercitoMonstruos = generadorMonstruos();
		System.out.println("Este es el menu de personajes, aqui tendras que elegir entre Arquero, Guerrero o Mago");
		System.out.println("Cual eliges?");
		System.out.println("\t Los arqueros son muy habiles a la hora de luchar, pueden hasta atacar dos veces por turno");
		System.out.println("\t Los guerreros son unos grandes, nobles y fuertes caballeros con gran armadura y mucha vida");
		System.out.println("\t Los magos provienen de una antigua civilizacion, pueden lanzar muchos hechizos y tienen mucho daño");
		String personaje = sc.next();
		System.out.println("Como te llamas?");
		String nombre = sc.next();
		h = seleccionDelPersonaje(personaje, nombre);
		
		//Aqui deberia de comenzar el menu de combate

		
	}
	
	public void combatePorTurnos() {
		
		
	}
	
	//Voy a generar los monstruos y meterlos en un arrayList
	//Para que cuando derrote a uno, este se borre y pase al siguiente
	public ArrayList<Monstruos> generadorMonstruos(){
		List<Monstruos> ejercitoMonstruos = new ArrayList<>();
		
		ejercitoMonstruos.add(new Esbirros());
		ejercitoMonstruos.add(new EsbirrosAltoNivel());
		ejercitoMonstruos.add(new Jefe());
		
		return (ArrayList<Monstruos>) ejercitoMonstruos;
		
		
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
