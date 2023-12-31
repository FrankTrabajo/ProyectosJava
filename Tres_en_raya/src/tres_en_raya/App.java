package tres_en_raya;

import java.util.Iterator;
import java.util.Scanner;

public class App {

	// Este es el juego del 3 en raya, muy simple
	// Primero haremos lo simple, colocar todas las piezas posibles hasta que no se
	// puedan poner mas
	// Mas tarde hare lo de quitar la piza que quieras hasta poder ganar (solo
	// tendrás 3 piezas claro )
	// Mas tarde hare un menu para que jueges con alguien o contra la maquina
	// Primero jugaremos contra alguien

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Creacion del tablero de juego!
		// Se jugará con letras X y O
		// Donde no haya nada serán .

		menu();

	}

	public static void menu() {
		String[][] tablero = crearTablero();
		mostrarTablero(tablero);
		// tablero = colocarPiezaJ1(tablero);
		// mostrarTablero(tablero);
		juego(tablero);
	}

	public static String[][] crearTablero() {
		String[][] tablero = new String[3][3];

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = ".";
			}
		}

		return tablero;
	}

	public static String[][] mostrarTablero(String[][] tablero) {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println("");
		}

		return tablero;
	}

	public static String[][] colocarPiezaJ1(String[][] tablero) {

		int posicionUno = 0;
		int posicionDos = 0;

		System.out.println("Jugador 1 coloque su pieza");
		do {
			System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
			try {
				posicionUno = sc.nextInt();
				if (posicionUno > 2) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
					posicionUno = -1;
				} else if (posicionUno < 0) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
				}
			} catch (Exception e) {
				System.out.println("Recueda que estamos jugando con numeros");
				posicionUno = -1;
				sc.next();
			}
		} while (posicionUno == -1);

		do {
			System.out.println("Diga las coordenadas de la columna (0 a 2 tanto fila y columna)");
			try {
				posicionDos = sc.nextInt();
				if (posicionDos > 2) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
					posicionDos = -1;
				} else if (posicionDos < 0) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
				}
			} catch (Exception e) {
				System.out.println("Recueda que estamos jugando con numeros");
				posicionDos = -1;
				sc.next();
			}
		} while (posicionUno == -1);

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				while (tablero[posicionUno][posicionDos] == "O") {
					System.out.println("Ahi no puedes poner, ya hay una pieza");
					System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
					try {
						posicionUno = sc.nextInt();
						if (posicionUno > 2) {
							System.out.println("Recueda el maximo es 2 y el minimo 0");
							posicionUno = -1;
						} else if (posicionUno < 0) {
							System.out.println("Recueda el maximo es 2 y el minimo 0");
						}
					} catch (Exception e) {
						System.out.println("Recueda que estamos jugando con numeros");
						posicionUno = -1;
						sc.next();
					}
					System.out.println("Diga las coordenadas de la columna (0 a 2 tanto fila y columna)");
					try {
						posicionDos = sc.nextInt();
						if (posicionDos > 2) {
							System.out.println("Recueda el maximo es 2 y el minimo 0");
							posicionDos = -1;
						} else if (posicionDos < 0) {
							System.out.println("Recueda el maximo es 2 y el minimo 0");
						}
					} catch (Exception e) {
						System.out.println("Recueda que estamos jugando con numeros");
						posicionDos = -1;
						sc.next();
					}
				}
				tablero[posicionUno][posicionDos] = "X";
			}
		}

		return tablero;
	}

	public static String[][] colocarPiezaJ2(String[][] tablero) {

		int posicionUno = 0;
		int posicionDos = 0;

		System.out.println("Jugador 2 coloque su pieza");
		do {
			System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
			try {
				posicionUno = sc.nextInt();
				if (posicionUno > 2) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
					posicionUno = -1;
				} else if (posicionUno < 0) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
				}
			} catch (Exception e) {
				System.out.println("Recueda que estamos jugando con numeros");
				posicionUno = -1;
				sc.next();
			}
		} while (posicionUno == -1);

		do {
			System.out.println("Diga las coordenadas de la columna (0 a 2 tanto fila y columna)");
			try {
				posicionDos = sc.nextInt();
				if (posicionDos > 2) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
					posicionDos = -1;
				} else if (posicionDos < 0) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
				}
			} catch (Exception e) {
				System.out.println("Recueda que estamos jugando con numeros");
				posicionDos = -1;
				sc.next();
			}
		} while (posicionUno == -1);

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				while (tablero[posicionUno][posicionDos] == "X") {
					System.out.println("Ahi no puedes poner, ya hay una pieza");
					do {
						System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
						try {
							posicionDos = sc.nextInt();
							if (posicionDos > 2) {
								System.out.println("Recueda el maximo es 2 y el minimo 0");
								posicionDos = -1;
							} else if (posicionDos < 0) {
								System.out.println("Recueda el maximo es 2 y el minimo 0");
							}
						} catch (Exception e) {
							System.out.println("Recueda que estamos jugando con numeros");
							posicionDos = -1;
							sc.next();
						}
					} while (posicionUno == -1);
					do {
						System.out.println("Diga las coordenadas de la columna (0 a 2 tanto fila y columna)");
						try {
							posicionDos = sc.nextInt();
							if (posicionDos > 2) {
								System.out.println("Recueda el maximo es 2 y el minimo 0");
								posicionDos = -1;
							} else if (posicionDos < 0) {
								System.out.println("Recueda el maximo es 2 y el minimo 0");
							}
						} catch (Exception e) {
							System.out.println("Recueda que estamos jugando con numeros");
							posicionDos = -1;
							sc.next();
						}
					} while (posicionUno == -1);
				}		
				tablero[posicionUno][posicionDos] = "O";
			}
		}
		return tablero;
	}

	public static boolean comprobarFin(String[][] tablero) {
		// Si han acabado devuelve True si no False
		boolean ret = false;
		int cont = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == ".") {
					cont++;
				}
			}
		}
		if (cont > 0) {
			ret = false;
		} else if (cont == 0) {
			ret = true;
		}
		cont = 0;
		return ret;
	}

	public static boolean comprobarGanador(String[][] tablero) {
		int cont = 0;
		boolean ganar = false;

		// JUGADOR 1
		// Primero lineas horizontales
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == "X") {
					cont++;
				}
				if (cont == 3) {
					System.out.println("Jugador 1 gana");
					ganar = true;
				}
			}
			cont = 0;

		}
		// Verticales
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[j][i] == "X") {
					cont++;
				}
				if (cont == 3) {
					System.out.println("Jugador 1 gana");
					ganar = true;
				}
			}
			cont = 0;

		}
		// Diagonal desde izquierda
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][i] == "X") {
				cont++;
			}
			if (cont == 3) {
				System.out.println("Jugador 1 gana");
				ganar = true;
			}
			cont = 0;
		}
		// Diagonal desde derecha
		for (int i = tablero.length - 1; i > 0; i--) {
			if (tablero[i][i] == "X") {
				cont++;
			}
			if (cont == 3) {
				System.out.println("Jugador 1 gana");
				ganar = true;
			}
			cont = 0;
		}

		// JUGADOR 2
		// HORIZONTAL
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == "O") {
					cont++;
				}
				if (cont == 3) {
					System.out.println("Jugador 2 gana");
					ganar = true;
				}
			}
			cont = 0;

		}
		// Verticales
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[j][i] == "O") {
					cont++;
				}
				if (cont == 3) {
					System.out.println("Jugador 2 gana");
					ganar = true;
				}
			}
			cont = 0;

		}
		// Diagonal desde izquierda
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][i] == "O") {
				cont++;
			}
			if (cont == 3) {
				System.out.println("Jugador 2 gana");
				ganar = true;
			}
			cont = 0;
		}
		// Diagonal desde derecha
		for (int i = 2; i > 0; i--) {
			if (tablero[i][i] == "O") {
				cont++;
			}
			if (cont == 3) {
				System.out.println("Jugador 2 gana");
				ganar = true;
			}
			cont = 0;
		}
		return ganar;
	}

	public static void juego(String[][] tablero) {

		boolean fin = comprobarFin(tablero);
		boolean ganador = comprobarGanador(tablero);

		while (fin == false) {
			while (ganador == false) {
				colocarPiezaJ1(tablero);
				mostrarTablero(tablero);
				fin = comprobarFin(tablero);
				ganador = comprobarGanador(tablero);
				if (fin == true) {
					ganador = true;
					System.out.println("Empate, no ha ganado nadie");
				}
				if (ganador == false) {
					colocarPiezaJ2(tablero);
					mostrarTablero(tablero);
					fin = comprobarFin(tablero);
					ganador = comprobarGanador(tablero);
					if (fin == true) {
						ganador = true;
						System.out.println("Empate, no ha ganado nadie");
					}
				}
			}
			fin = true;
		}
		System.out.println("*******************************************");
		System.out.println("Se ha acabado el juego");
		System.out.println("*******************************************");
	}

}
