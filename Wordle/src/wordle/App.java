package wordle;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> diccionario = new ArrayList<String>();
	
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
	}
}
