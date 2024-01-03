package wordle;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> diccionario = new ArrayList<String>();
	private static char[] tableroJugador = new char[5];

	public static void main(String[] args) {

		juego();

	}

	public static char[] crearTablero() {

		for (int i = 0; i < tableroJugador.length; i++) {
			tableroJugador[i] = '_';
		}

		return tableroJugador;
	}

	public static char[] palabraDelDia() {
		char[] palabraDelDia = new char[5];
		int numeroAleatorio = (int) (Math.random() * diccionario.size());
		// Hay que sacar una palabra de la lista

		String palabra = diccionario.get(numeroAleatorio);
		System.out.println(palabra);

		for (int i = 0; i < palabraDelDia.length; i++) {
			char letra = palabra.charAt(i);
			palabraDelDia[i] = letra;
		}

		return palabraDelDia;
	}

	public static char[] comprobarPalabra(char[] palabraDelDia) {

		System.out.println("Escribe la palabra del dia");
		String palabra = sc.next();

		char[] palabraJugador = new char[5];
		for (int i = 0; i < palabraJugador.length; i++) {
			char letra = palabra.charAt(i);
			palabraJugador[i] = letra;
		}

		for (int i = 0; i < palabraJugador.length; i++) {
			if (palabraJugador[i] == palabraDelDia[i]) {
				tableroJugador[i] = palabraJugador[i];
			}
		}

		for (int i = 0; i < tableroJugador.length; i++) {
			System.out.print(tableroJugador[i] + " ");
		}

		return tableroJugador;
	}

	public static boolean comprobarFinal(char[] tablero) {
		// Si el juego acaba devuelve true
		// Si el juego sigue devuelve false
		int cont = 0;
		boolean seguir;
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i] == '_') {
				cont++;
			}
		}

		if (cont == 0) {
			// El juego ha acabado
			seguir = true;
		} else {
			seguir = false;
		}

		return seguir;
	}

	public static void juego() {
		int vidas = 6;
		// De momento 5 palabras de 5 letras cada una
		diccionario.add("ABEJA");
		diccionario.add("SUELA");
		diccionario.add("SALUD");
		diccionario.add("CASCO");
		diccionario.add("FINCA");

		// Las palabras seran de 5 letras
		// Vamos a mostrar las celdas con '_' para cuando no hayamos acertado la letra
		crearTablero();// Lo que hace esto es rellenar el tablero con _
		// Ahora tenemos que coger "la palabra del dia", para ello crearemos un random
		// de logintud
		// La lista del diccionario y de minimo 1
		char[] palabraJuego = palabraDelDia();

		boolean iniciarJuego = true;

		System.out.println("Esto es adivinar la palabra del dia en 6 intentos");
		System.out.println("Si fallas has perdido");

		while (vidas > 0) {
			comprobarPalabra(palabraJuego);
			iniciarJuego = comprobarFinal(comprobarPalabra(palabraJuego));
			if(iniciarJuego == true) {
				System.out.println("Muy Bien! HAS GANADO");
				vidas = -1;
			}
		}

	}
}
