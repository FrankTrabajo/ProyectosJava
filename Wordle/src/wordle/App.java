package wordle;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.FontUIResource;

public class App {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> diccionario = new ArrayList<String>();
	private static char[] tableroJugador = new char[5];
	
	public static void main(String[] args) {
		
		//Vamos a crear una lista de palabras, las cuales nos serviran como "diccionario"
		//Lo que trata este juego es de ir adivinando la "palabra del dia"
		//Aqui un ejemplo:
		//	Si la palabra es "SUELA" y escribirmos "ABEJA" diremos cual de estas letras aparece en 
		//	la palabra del dia y la que esté bien puesta la mostraremos al usuario
		
		//De momento 5 palabras de 5 letras cada una
		diccionario.add("ABEJA");
		diccionario.add("SUELA");
		diccionario.add("SALUD");
		diccionario.add("CASCO");
		diccionario.add("FINCA");
		
		//Las palabras seran de 5 letras
		//Vamos a mostrar las celdas con '_' para cuando no hayamos acertado la letra
		crearTablero();//Lo que hace esto es rellenar el tablero con _ 
		//Ahora tenemos que coger "la palabra del dia", para ello crearemos un random de logintud
		//La lista del diccionario y de minimo 1
		char[] palabraJuego = palabraDelDia();
		
		
		
	}
	
	public static char[] crearTablero() {
	
		for (int i = 0; i < tableroJugador.length; i++) {
			tableroJugador[i] = '_';
		}
		
		return tableroJugador;
	}
	
	public static char[] palabraDelDia() {
		char[] palabraDelDia = new char[5];
		int numeroAleatorio = (int) (Math.random()*diccionario.size()+1);
		//Hay que sacar una palabra de la lista
		
		String palabra = diccionario.get(numeroAleatorio);
		
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
			if(palabraJugador[i] == palabraDelDia[i]) {
				tableroJugador[i] = palabraJugador[i];
			}
		}
		
		return tableroJugador;
	}
}
