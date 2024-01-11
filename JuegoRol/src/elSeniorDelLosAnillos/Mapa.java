package elSeniorDelLosAnillos;

import java.util.List;

public class Mapa {

	// Atributos
	int dado1;
	int dado2;
	int ataque;
	int turno = 1;
	int cont = 0;
	List<Heroes> heroes;
	List<Bestias> bestias;

	public Mapa(List<Heroes> heroes, List<Bestias> bestias) {
		super();
		this.heroes = heroes;
		this.bestias = bestias;
	}

	// Metodo batalla

	public void batalla(List<Heroes> h, List<Bestias> b) {
		// creacion de dados y asignacion del daño
		dado1 = (int) (Math.random() * 100);
		dado2 = (int) (Math.random() * 100);
		if (dado1 > dado2) {
			ataque = dado1;
		} else if (dado2 > dado1) {
			ataque = dado2;
		} else if (dado1 == dado2) {
			ataque = dado1;
		}
		// Creacion de la batalla
		while (!heroes.isEmpty() && !bestias.isEmpty()) {

			Heroes heroe = heroes.get(0);
			Bestias bestia = bestias.get(0);

			System.out.println("\t Turno: " + turno);

			// Ataque de heroe
			System.out.println("Esta atacando " + heroe.nombre);
			heroe.presentacion();
			System.out.println("Ha tirado los dados y el numero que ha sacado es: " + ataque);
			System.out.println(heroe.nombre + " Ha hecho " + ataque + " de daño a " + bestia.getNombre());
			bestia.ataque(ataque);
			System.out.println(bestia.getNombre() + " actualizacion de vida " + bestia.toString());

			// Ataque de bestias
			System.out.println("Esta atacando " + bestia.nombre);
			bestia.presentacion();
			System.out.println("Ha tirado los dados y el numero que ha sacado es: " + dado1);
			System.out.println(bestia.nombre + " Ha hecho " + dado1 + " de daño a " + heroe.nombre);
			heroe.ataque(dado1);
			System.out.println("Actualizacion de vida " + heroe.toString());

			if (heroe.vida <= 0) {
				heroes.remove(heroe);
				System.out.println(heroe.nombre + " Ha sido derrotado");
			} else if (bestia.vida <= 0) {
				bestias.remove(bestia);
				System.out.println(bestia.nombre + " Ha sido derrotado");
			}
			turno++;

			// creacion de dados y asignacion del daño
			dado1 = (int) (Math.random() * 100);
			dado2 = (int) (Math.random() * 100);
			if (dado1 > dado2) {
				ataque = dado1;
			} else if (dado2 > dado1) {
				ataque = dado2;
			} else if (dado1 == dado2) {
				ataque = dado1;
			}

			// Dar victoria
			if(h.isEmpty()) {
				System.out.println("Ya no quedan mas Heroes");
				System.out.println("Han ganado las Bestias");
			} else if (b.isEmpty()) {
				System.out.println("Ya no quedan mas bestias");
				System.out.println("Han ganado los Heroes");
			}

		}

	}

}


