package maquinaExpendedora;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
	final static String[] arrayBebida = { "Agua", "Coca cola", "Coca cola zero", "Caf� solo", "Caf� con leche" };
	final static char[] arrayBebidaCodigo = { 'A', 'B', 'C', 'D', 'E' };
	final static double[] arrayBebidaPrecio = { 1.00, 1.40, 1.45, 0.65, 0.80 };

	final static String[] arrayComida = { "Sandwitch mixto", "Empanada", "Patatas fritas", "Pizza", "Hamburguesa" };
	final static char[] arrayComidaCodigo = { 'F', 'G', 'H', 'I', 'J' };
	final static double[] arrayComidaPrecio = { 2.35, 1.75, 0.90, 5.65, 4.95 };

	final static double[] dinero = { 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01 };

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.00");
		Scanner sc = new Scanner(System.in);
		boolean maquinaOperativa = true;
		double calentarComida = 0;
		int seleccion;
		System.out.println("Esto es una mauqina expendedora!");
	}

	public static int[] calcularCambio(double dineroIntroducido, double precio) {
		int[] cambio = new int[11];

		int cont = 0;

		DecimalFormat df = new DecimalFormat("#.00");

		// Introduce el dinero ejemplo 12,4�
		// El precio supongamos que es 2�
		// Hacemos la resta de 12,4 - 2 = 10,4�

		double vuelta = dineroIntroducido - precio;
		df.format(vuelta);

		// Como hacer que pare y vuelva a repetir

		for (int i = 0; i < cambio.length; i++) {
			for (int j = 0; j < dinero.length; j++) {
				if ((vuelta - dinero[i]) >= 0) {
					vuelta = vuelta - dinero[i];
					cont++;
					cambio[i] = cont;
				}
			}
			cont = 0;
		}

		return cambio;
	}

	public static double introducirDinero(double num1) {

		for (int i = 0; i < dinero.length; i++) {
			if (num1 == dinero[i]) {
				return num1;
			}
		}

		return 0;
	}
	
	public static void visualizarBebidas() {
		for (int i = 0; i < arrayBebida.length; i++) {
			System.out.println("Nombre: " + arrayBebida[i] + " |Codigo: " + arrayBebidaCodigo[i] + " |Precio: "
					+ arrayBebidaPrecio[i] + "||");
		}
	}

	public static void visualizarComida() {
		for (int i = 0; i < arrayComida.length; i++) {
			System.out.println("Nombre: " + arrayComida[i] + " |Codigo: " + arrayComidaCodigo[i] + " |Precio: "
					+ arrayComidaPrecio[i] + "||");
		}
	}

	public static void comprarBebida() {
		System.out.println("La compra se ha realizado!");
		// Este es tu cambio
	}

	public static void comprarComida() {
		System.out.println("La compra se ha realizado!");
		// Este es tu cambio
	}
	
	public static int seleccionarBebida(char codigo) {
		int ret = -1;
		for (int i = 0; i < arrayBebidaCodigo.length; i++) {
			if (codigo == arrayBebidaCodigo[i]) {
				ret = i;
				break;
			}
		}
		return ret;
	}

	public static int seleccionarComida(char codigo) {
		int ret = 0;
		for (int i = 0; i < arrayComidaCodigo.length; i++) {
			if (codigo == arrayComidaCodigo[i]) {
				ret = i;
				break;
			}
		}
		return ret;
	}
}
