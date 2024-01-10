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
		}
	
}

