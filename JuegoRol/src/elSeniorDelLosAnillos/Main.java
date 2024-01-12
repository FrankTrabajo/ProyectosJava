package elSeniorDelLosAnillos;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Heroes> ejercitoHeroes = new ArrayList<>();
		List<Bestias> ejercitoBestias = new ArrayList<>();
		
		//EJERCITO DE HEROES
		ejercitoHeroes.add(new Elfo("Legolas", 120, 60));
		ejercitoHeroes.add(new Humano("Gandalf", 140, 30));
		ejercitoHeroes.add(new Hobbit("Froddo", 100, 20));
		
		//EJERCITO DE BESTIAS
		ejercitoBestias.add(new Orcos("Malhur", 200, 50));
		ejercitoBestias.add(new Trasgos("Aruna", 180, 50));
		
		
		
		Mapa combate = new Mapa(ejercitoHeroes, ejercitoBestias);
		combate.batalla(ejercitoHeroes, ejercitoBestias);
		
	}

}

