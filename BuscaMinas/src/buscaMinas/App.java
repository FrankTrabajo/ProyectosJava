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
	
	public static boolean finPartida(int[][] tablero){
        //devuelve falso si quedan casillas por marcar
        //devuelve cierto si no quedan casillas a 0
        //---------------------------------------------------
        //si fin es = a true has ganado
        //si fin es = a false aun no has ganado
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
	
	public static boolean minaCerca(int[][] tablero, int columna, int fila){
        //devuelve cierto si hay una mina cerca
        //devuelve false si no hay una mina cerca

        int mina = 0;

                
                //Miramos los valores de la izquierda cuando se pueda
                if(columna != 0){
                    if(tablero[fila][columna-1] == 1){
                        mina++;
                    }

                    //izquierda arriba
                    if (fila != 0){
                        if(tablero[fila-1][columna-1] == 1){
                            mina++;
                        } 
                    }
                    //izquierda abajo
                    if (fila != (6-1)){
                        if(tablero[fila+1][columna-1] == 1){
                            mina++;
                        } 
                    }
                }
                if(columna != (6-1)){
                    //Podemos comprobar los valores de la derecha
                    //justo a la derecha
                    if(tablero[fila][columna+1] == 1){
                        mina++;
                    }

                    //derecha arriba
                    if (fila != 0){
                        if(tablero[fila-1][columna+1] == 1){
                            mina++;
                        } 
                    }
                    //izquierda abajo
                    if (fila != (6-1)){
                        if(tablero[fila+1][columna+1] == 1){
                            mina++;
                        } 
                    }

                }
                if (fila != 0){
                    //Podemos comprobar los valores de arriba
                    if(tablero[fila-1][columna] == 1){
                        mina++;
                    }
                }
                if(fila != (6-1)){
                    if(tablero[fila+1][columna] == 1){
                        mina++;
                    }
                }

                if(mina > 0){
                    System.out.println("Cuidado!!!!! \tHay " + mina + " minas cerca");
                    return true;
                }else {
                    System.out.println("No hay minas cerca");
                    return false;
                }
    }

}
