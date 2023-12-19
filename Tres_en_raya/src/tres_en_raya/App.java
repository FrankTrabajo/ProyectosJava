package tres_en_raya;

import java.util.Iterator;
import java.util.Scanner;

public class App {

	//Este es el juego del 3 en raya, muy simple
	//Primero haremos lo simple, colocar todas las piezas posibles hasta que no se puedan poner mas
	//Mas tarde hare lo de quitar la piza que quieras hasta poder ganar (solo tendrás 3 piezas claro )
	//Mas tarde hare un menu para que jueges con alguien o contra la maquina
	//Primero jugaremos contra alguien
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		//Creacion del tablero de juego!
		//Se jugará con letras X y O
		//Donde no haya nada serán .
		
		menu();
		

	}
	
	public static void menu() {
		String [][] tablero = crearTablero();
		mostrarTablero(tablero);
		//tablero = colocarPiezaJ1(tablero);
		//mostrarTablero(tablero);
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
	
	public static String[][] mostrarTablero(String[][] tablero){
		
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println("");
		}
		
		return tablero;
	}
	
	public static String[][] colocarPiezaJ1(String[][] tablero){
		
		int posicionUno = 0;
		int posicionDos = 0;
		
		System.out.println("Jugador 1 coloque su pieza");
		System.out.println("Solo puede ser X");
		do {
		System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
		try {
			posicionUno = sc.nextInt();
			if (posicionUno > 2) {
				System.out.println("Recueda el maximo es 2 y el minimo 0");
				posicionUno = -1;
			}
			else if (posicionUno < 0) {
				System.out.println("Recueda el maximo es 2 y el minimo 0");
			}
		} catch (Exception e) {
			System.out.println("Recueda que estamos jugando con numeros");
			posicionUno = -1;
			sc.next();
		}
		}while(posicionUno == -1);
		
		do {
			System.out.println("Diga las coordenadas de la columna (0 a 2 tanto fila y columna)");
			try {
				posicionDos = sc.nextInt();
				if (posicionDos > 2) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
					posicionDos = -1;
				}
				else if (posicionDos < 0) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
				}
			} catch (Exception e) {
				System.out.println("Recueda que estamos jugando con numeros");
				posicionDos = -1;
				sc.next();
			}
			}while(posicionUno == -1);

		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				while(tablero[posicionUno][posicionDos] == "O") {
					System.out.println("Ahi no puedes poner, ya hay una pieza");
						System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
						try {
							posicionUno = sc.nextInt();
							if (posicionUno > 2) {
								System.out.println("Recueda el maximo es 2 y el minimo 0");
								posicionUno = -1;
							}
							else if (posicionUno < 0) {
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
								}
								else if (posicionDos < 0) {
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
	
public static String[][] colocarPiezaJ2(String[][] tablero){
		
		int posicionUno = 0;
		int posicionDos = 0;
		
		System.out.println("Jugador 1 coloque su pieza");
		System.out.println("Solo puede ser O");
		do {
		System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
		try {
			posicionUno = sc.nextInt();
			if (posicionUno > 2) {
				System.out.println("Recueda el maximo es 2 y el minimo 0");
				posicionUno = -1;
			}
			else if (posicionUno < 0) {
				System.out.println("Recueda el maximo es 2 y el minimo 0");
			}
		} catch (Exception e) {
			System.out.println("Recueda que estamos jugando con numeros");
			posicionUno = -1;
			sc.next();
		}
		}while(posicionUno == -1);
		
		do {
			System.out.println("Diga las coordenadas de la columna (0 a 2 tanto fila y columna)");
			try {
				posicionDos = sc.nextInt();
				if (posicionDos > 2) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
					posicionDos = -1;
				}
				else if (posicionDos < 0) {
					System.out.println("Recueda el maximo es 2 y el minimo 0");
				}
			} catch (Exception e) {
				System.out.println("Recueda que estamos jugando con numeros");
				posicionDos = -1;
				sc.next();
			}
			}while(posicionUno == -1);

		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				while(tablero[posicionUno][posicionDos] == "X") {
					System.out.println("Ahi no puedes poner, ya hay una pieza");
						System.out.println("Diga las coordenadas de la fila (0 a 2 tanto fila y columna)");
						try {
							posicionUno = sc.nextInt();
							if (posicionUno > 2) {
								System.out.println("Recueda el maximo es 2 y el minimo 0");
								posicionUno = -1;
							}
							else if (posicionUno < 0) {
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
								}
								else if (posicionDos < 0) {
									System.out.println("Recueda el maximo es 2 y el minimo 0");
								}
							} catch (Exception e) {
								System.out.println("Recueda que estamos jugando con numeros");
								posicionDos = -1;
								sc.next();
							}
				}
				tablero[posicionUno][posicionDos] = "O";
			}
		}
		
		return tablero;
	}

	public static boolean comprobarFin(String[][] tablero) {
		//Si han acabado devuelve True si no False
		boolean ret = false;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j] == ".") {
					ret = false;
				} else {
					ret = true;
				}
			}
		}
		
		
		return ret;
	}
	
	public static void juego(String[][] tablero) {
		
		boolean fin = comprobarFin(tablero);
		
		while(fin == false) {
			//Comienza el jugador 1
			//Seguido el jugador 2
			tablero = colocarPiezaJ1(tablero);
			mostrarTablero(tablero);
			fin = comprobarFin(tablero);
			tablero = colocarPiezaJ2(tablero);
			mostrarTablero(tablero);
			fin = comprobarFin(tablero);
		}
		System.out.println("Fin");
	}

}
