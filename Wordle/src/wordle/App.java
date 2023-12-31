package wordle;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> diccionario = new ArrayList<String>();
	private static String[] tableroJugador = new String[5];
	
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
		int numeroAleatorio = (int) (Math.random()*diccionario.size()+1);
		
		
	}
	
	public static String[] crearTablero() {
	
		for (int i = 0; i < tableroJugador.length; i++) {
			tableroJugador[i] = "_";
		}
		
		return tableroJugador;
	}
	
	public static String[] palabraDelDia(int numero) {
		String[] palabraDelDia = new String[5];
		
		return palabraDelDia;
	}
}
