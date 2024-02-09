package lagunaJuego;

import java.util.ArrayList;

import lagunaJuego.Heroes.Heroe;
import lagunaJuego.Monstruos.Monstruos;

public class Main {

	public static void main(String[] args) {
		
		Heroe jugador = new Heroe();
		ArrayList<Monstruos> ejercitoMonstruos = new ArrayList<>();
		
		MapaDeJuego mapa = new MapaDeJuego();
		
		ejercitoMonstruos = mapa.generadorMonstruos();
		mapa.comienzoDelJuego(jugador, ejercitoMonstruos);
	}

}
