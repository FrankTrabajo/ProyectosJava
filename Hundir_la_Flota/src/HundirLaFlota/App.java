package HundirLaFlota;

import java.util.Iterator;
import java.util.Scanner;

public class App {

	private static int ROW = 0, COL = 0;
	private static final int AGUA = 0;
	private static final String WATER = "A";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Este es el juego de hundir la flota convencional solo que se trata de
		// adivinar donde ha puesto la maquina los barcos
		// Vamos a crear 2 barcos de 5 casillas
		// 3 barcos de 3 casillas
		// 5 barcos de 2 casillas
		// Todo esto de forma aleatoria
		menu();
	}

	// Este será el menú del juego
	public static void menu() {
		System.out.println("Bienvenidos al juego de hundir la flota");
		System.out.println("Lo que harás será adivinar donde están los barcos puestos por la máquina");
		System.out.println("Tienes vidas, estas vidas bajaran cada vez que falles, asi que ten cuidado");
		System.out.println("Primero de todo, escribe las dimensiones de tu tablero");
		System.out.println("Como minimo tiene que ser de 10x10 y como máximo de 15x15");
		do {
			System.out.print("Filas: ");
			try {
				ROW = sc.nextInt();
				if (ROW < 10 || ROW > 15) {
					System.out.println("Recuerda que el minimo de filas es 10 y el maximo 15");
					ROW = -1;
				}
			} catch (Exception e) {
				System.out.println("Recuerda que el minimo de filas es 10 y el maximo 15");
				ROW = -1;
				sc.next();
			}

		} while (ROW < 0);
		do {
			System.out.print("Columnas: ");
			try {
				COL = sc.nextInt();
				if (COL < 10 || COL > 15) {
					System.out.println("Recuerda que el minimo de filas es 10 y el maximo 15");
					COL = -1;
				}
			} catch (Exception e) {
				System.out.println("Recuerda que el minimo de filas es 10 y el maximo 15");
				COL = -1;
				sc.next();
			}

		} while (COL < 0);
		System.out.println("Vamos a crear tu tablero!");
		// Este es el tablero donde vas a jugar
		int[][] tablero = tablero(ROW, COL);
		// Este sera el tablero que veras a la hora de marcar las casillas
		String[][] tableroJugador = tableroJugador(ROW, COL);

		// Hemos creado los tableros de juego y el que verá el jugador
		// Vamos a mostrar el tablero del jugador
		mostrarTableroJugador(tableroJugador);
		barcosDeDos(tablero);
		//mostrarTablero(tablero);
		menu2();
		hundirBarcos(tablero, tableroJugador);
	}

	public static int[][] tablero(int filas, int columnas) {
		int[][] tablero = new int[ROW][COL];

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = AGUA;
			}
		}
		return tablero;
	}

	public static String[][] tableroJugador(int filas, int columnas) {
		// El tablero del jugador sera de string y se pondrá todo con '.'
		String[][] tableroJugador = new String[ROW][COL];
		for (int i = 0; i < tableroJugador.length; i++) {
			for (int j = 0; j < tableroJugador[i].length; j++) {
				tableroJugador[i][j] = ".";
			}
		}
		return tableroJugador;
	}

	public static void mostrarTableroJugador(String[][] tableroJugador) {
		for (int i = 0; i < tableroJugador.length; i++) {
			for (int j = 0; j < tableroJugador[i].length; j++) {
				System.out.print(tableroJugador[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void mostrarTablero(int[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println("");
		}
	}

	// Vamos a introducir los barcos dentro del tablero
	public static int[][] barcosDeCinco(int[][] tablero) {
		for (int i = 0; i < 2; i++) {
			int horizontalOVertical = (int) (Math.random() * 2 + 1);

			int rowRandom = (int) (Math.random() * ROW);
			int colRandom = (int) (Math.random() * COL);

			for (int k = rowRandom - 4, l = colRandom - 4; k < 10 && l < 10; k++, l++) {
				// si desde la posicion en la que esta rowRandom no hay ningun 5, 4 bloques a la
				// derecha y a la izquierda, se pone
				try {
					if (tablero[k][colRandom] == 5 || tablero[rowRandom][l] == 5) {
						rowRandom = (int) (Math.random() * ROW);
						colRandom = (int) (Math.random() * COL);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			for (int j = 0; j < 5; j++) {
				if (horizontalOVertical == 1) {
					if (colRandom + 4 < COL) {
						tablero[rowRandom][colRandom + j] = 50 + i;
					} else {
						tablero[rowRandom][colRandom - j] = 50 + i;
					}
				} else {
					if (rowRandom + 4 < ROW) {
						tablero[rowRandom + j][colRandom] = 50 + i;
					} else {
						tablero[rowRandom - j][colRandom] = 50 + i;
					}
				}
			}
		}

		return tablero;
	}

	public static int[][] barcosDeTres(int[][] tablero) {
		boolean tocar = false;
		while (tocar == false) {
			tablero = barcosDeCinco(tablero);
			tocar = true;
			// Creacion de 5 barcos de 2

			for (int i = 0; i < 3; i++) {
				int horizontalOVertical = (int) (Math.random() * 2 + 1);
				int rowRandom = (int) (Math.random() * ROW);
				int colRandom = (int) (Math.random() * COL);
				for (int j = 0; j < 3; j++) {
					if (horizontalOVertical == 1) {
						// Horizontal
						if (colRandom + j < COL - 3) {
							if (tablero[rowRandom][colRandom + j] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom][colRandom + j] = 30 + i;
							}
						} else {
							if (tablero[rowRandom][colRandom - j] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom][colRandom - j] = 30 + i;
							}
						}
					} else {
						// Vertical
						if (rowRandom + j < ROW - 3) {
							if (tablero[rowRandom + j][colRandom] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom + j][colRandom] = 30 + i;
							}
						} else {
							if (tablero[rowRandom - j][colRandom] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom - j][colRandom] = 30 + i;
							}
						}
					}
				}
			}
			if (tocar == false) {
				for (int i = 0; i < tablero.length; i++) {
					for (int j = 0; j < tablero[i].length; j++) {
						tablero[i][j] = 0;
					}
				}
			}
		}
		return tablero;
	}

	public static int[][] barcosDeDos(int[][] tablero) {
		// tablero = barcosDeTres(tablero);
		boolean tocar = false;
		while (tocar == false) {
			tablero = barcosDeTres(tablero);
			tocar = true;
			// Creacion de 5 barcos de 2

			for (int i = 0; i < 5; i++) {
				int horizontalOVertical = (int) (Math.random() * 2 + 1);
				int rowRandom = (int) (Math.random() * ROW);
				int colRandom = (int) (Math.random() * COL);
				for (int j = 0; j < 2; j++) {
					if (horizontalOVertical == 1) {
						// Horizontal
						if (colRandom + j < COL - 2) {
							if (tablero[rowRandom][colRandom + j] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom][colRandom + j] = 20 + i;
							}
						} else {
							if (tablero[rowRandom][colRandom - j] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom][colRandom - j] = 20 + i;
							}
						}
					} else {
						// Vertical
						if (rowRandom + j < ROW - 2) {
							if (tablero[rowRandom + j][colRandom] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom + j][colRandom] = 20 + i;
							}
						} else {
							if (tablero[rowRandom - j][colRandom] != 0) {
								tocar = false;
							} else {
								tablero[rowRandom - j][colRandom] = 20 + i;
							}
						}
					}
				}
			}
			if (tocar == false) {
				for (int i = 0; i < tablero.length; i++) {
					for (int j = 0; j < tablero[i].length; j++) {
						tablero[i][j] = 0;
					}
				}
			}
		}

		return tablero;
	}
	
	public static void menu2() {
		System.out.println("Ya esta creado el tablero de juego");
		System.out.println("A partir de ahora el juego comenzará");
		System.out.println("Recueda, tienes una serie de vidas, no te olvides");
		System.out.println("Te iremos mostrando las vidas que te quedan a medida que vayas fallando");
		System.out.println("MUCHA SUERTE!!");
		System.out.println("*******************************************************");
	}
	
	public static void hundirBarcos(int[][] tablero, String[][] tableroJugador) {
		
		int vidasJugador = ROW + COL + 5;
		
		//Contadores de barcos de 2
		int contDos = 0;
		int contDosUno = 0;
		int contDosDos = 0;
		int contDosTres = 0;
		int contDosCuatro = 0;
		//Contadores de barcos de 3
		int contTres = 0;
		int contTresUno = 0;
		int contTresDos = 0;
		//Contadores de barcos de 5
		int contCinco = 0;
		int contCincoUno = 0;
		
		int coordenadaFila = 0;
		int coordenadaColumna = 0;
		//Listado de coordenadas
		String[] coordenadas = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P" };

		for (int i = 0; i < coordenadas.length; i++) {
			if (ROW == i) {
				System.out.println("Tu coordenadas de linea son de la A a la " + coordenadas[i - 1]);
			}
			if (COL == i) {
				System.out.println("Tu coordenadas de columna son de la A a la " + coordenadas[i - 1]);
			}
		}
		System.out.println("Ya sabes cual es tu rango de coordenadas");
		while (vidasJugador > 0 || todosBarcosHundidos(tablero) == false) {
			System.out.println("Realiza tu tirada");
			System.out.println("Coordenada de la fila: ");
			String fila = sc.next();
			System.out.println("coordenada de la columna: ");
			String columna = sc.next();

			for (int i = 0; i < coordenadas.length; i++) {
				if (coordenadas[i].equalsIgnoreCase(fila)) {
					coordenadaFila = i;
				}
				if (coordenadas[i].equalsIgnoreCase(columna)) {
					coordenadaColumna = i;
				}
			}

			if (tablero[coordenadaFila][coordenadaColumna] == 0) {
				System.out.println("Has dado agua!");
				vidasJugador--;
				System.out.println("Una vida menos, te quedan: " + vidasJugador);
				tableroJugador[coordenadaFila][coordenadaColumna] = "A";

			}
			// **************************************************************************************
			else if (tablero[coordenadaFila][coordenadaColumna] == 20) {

				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 2");
				contDos++;
				if (contDos == 2) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 20) {
								tableroJugador[i][j] = "2";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 2 hundido!!");
					contDos = 0;
				}

			} else if (tablero[coordenadaFila][coordenadaColumna] == 21) {

				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 2");
				contDosUno++;
				if (contDosUno == 2) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 21) {
								tableroJugador[i][j] = "2";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 2 hundido!!");
					contDosUno = 0;
				}

			} else if (tablero[coordenadaFila][coordenadaColumna] == 22) {

				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 2");
				contDosDos++;
				if (contDosDos == 2) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 22) {
								tableroJugador[i][j] = "2";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 2 hundido!!");
					contDosDos = 0;
				}

			} else if (tablero[coordenadaFila][coordenadaColumna] == 23) {

				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 2");
				contDosTres++;
				if (contDosTres == 2) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 23) {
								tableroJugador[i][j] = "2";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 2 hundido!!");
					contDosTres = 0;
				}

			} else if (tablero[coordenadaFila][coordenadaColumna] == 24) {

				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 2");
				contDosCuatro++;
				if (contDosCuatro == 2) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 24) {
								tableroJugador[i][j] = "2";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 2 hundido!!");
					contDosCuatro = 0;
				}

			}
			// **********************************************************************************
			else if (tablero[coordenadaFila][coordenadaColumna] == 30) {
				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 3");
				contTres++;
				if (contTres == 3) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 30) {
								tableroJugador[i][j] = "3";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 3 hundido!!");
					contTres = 0;
				}

			} else if (tablero[coordenadaFila][coordenadaColumna] == 31) {
				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 3");
				contTresUno++;
				if (contTresUno == 3) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 31) {
								tableroJugador[i][j] = "3";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 3 hundido!!");
					contTresUno = 0;
				}

			} else if (tablero[coordenadaFila][coordenadaColumna] == 32) {
				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 3");
				contTresDos++;
				if (contTresDos == 3) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 32) {
								tableroJugador[i][j] = "3";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 3 hundido!!");
					contTresDos = 0;
				}

			}
			// ************************************************************************************
			else if (tablero[coordenadaFila][coordenadaColumna] == 50) {

				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 5");
				contCinco++;
				if (contCinco == 5) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 50) {
								tableroJugador[i][j] = "5";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 5 hundido!!");
					contCinco = 0;
				}
			} else if (tablero[coordenadaFila][coordenadaColumna] == 51) {

				
				tableroJugador[coordenadaFila][coordenadaColumna] = "X";
				System.out.println("Has dado a un barco de 5");
				contCincoUno++;
				if (contCincoUno == 5) {
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if (tablero[i][j] == 51) {
								tableroJugador[i][j] = "5";
								tablero[i][j]= 0;
							}
						}
					}
					System.out.println("Barco de 5 hundido!!");
					contCincoUno = 0;
				}
			}
			for (int i = 0; i < COL; i++) {
				System.out.print(coordenadas[i] + " ");
			}
			System.out.println();
			System.out.println("*********************************");
			mostrarTableroJugador(tableroJugador);
		}
		if (vidasJugador < 0) {
			System.out.println("Has perdido!!!");
		}

	}

	public static boolean todosBarcosHundidos(int[][] tablero) {

		boolean ret = false;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == 0) {
					ret = true;
				}
			}
		}

		return ret;
	}

}
