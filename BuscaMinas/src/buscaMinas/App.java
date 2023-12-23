package buscaMinas;

import java.util.Scanner;

public class App {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Este sera un juego aprecido al buscaminas, lo que tienes que hacer es
		// intentar encontrar la bandera
		// y no pisar ninguna mina
		// Empecemos con la creacion del tablero
		// El tablero sera de 6 x 6

		int[][] tablero = crearTablero();
		int[][] tableroJugador = new int[6][6];
		mostrarTablero(tablero);
	}

	public static void mostrarTablero(int[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}

	// Vamos a crear el tablero donde se jugará
	public static int[][] crearTablero() {
		// Creamos el tablero 6x6
		int[][] tablero = new int[6][6];

		// ---------CREACION DE MINAS-------------
		for (int i = 0; i < 8; i++) {
			int pos1 = (int) (Math.random() * 6);
			int pos2 = (int) (Math.random() * 6);
			// Si el numero de las posiciones se repite, se vuelve a hacer otra tirada
			while (tablero[pos1][pos2] == 1) {
				pos1 = (int) (Math.random() * 6);
				pos2 = (int) (Math.random() * 6);
			}
			// Luego pongo la mina
			tablero[pos1][pos2] = 1;
		}

		// --------CREACION DE VICTORIA--------
		int pos1 = (int) (Math.random() * 6);
		int pos2 = (int) (Math.random() * 6);

		while (tablero[pos1][pos2] == 1) {
			pos1 = (int) (Math.random() * 6);
			pos2 = (int) (Math.random() * 6);
		}
		
		
		return tablero;
	}
}
