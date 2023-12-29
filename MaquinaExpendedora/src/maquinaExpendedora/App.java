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

		while (maquinaOperativa) {

			System.out.println("Elige una opcion: ");
			System.out.println("(1) Comida: ");
			System.out.println("(2) Bebida: ");
			System.out.println("(3) Salir: ");

			seleccion = sc.nextInt();

			while (seleccion == 1) {
				System.out.println("Has seleccionado Comida:");
				System.out.println("�Que quieres hacer ahora?");
				System.out.println("(1) Mostrar Comida:");
				System.out.println("(2) Seleccionar c�digo:");
				System.out.println("(3) Atras:");
				System.out.println("(4) Salir:");
				int seleccion2 = sc.nextInt();
				switch (seleccion2) {
				case 1:
					System.out.println("Mostrar comida:");
					visualizarComida();
					break;
				case 2:
					System.out.println("Seleccionar codigo:");
					for (int i = 0; i < arrayComidaCodigo.length; i++) {
						System.out.print(arrayComidaCodigo[i] + ", ");
					}
					String cod = sc.next();

					int codigo = seleccionarComida(cod.charAt(0));

					System.out.println("Has seleccionado: ");
					System.out.println(arrayComida[codigo] + " su precio es: " + arrayComidaPrecio[codigo]);
					if(!arrayComida[codigo].equalsIgnoreCase("Patatas fritas")) {
						System.out.print("Tenemos la opcion de calentarte la comida serian 0,45centimos mas ");
						System.out.print("�Quieres que te calentemos la comida? (Si/No) ");
						String caliente = sc.next();
						if(caliente.equalsIgnoreCase("si")) {
							calentarComida = 0.45;
						}
					}
					System.out.println("Vamo a cobrarte:");
					System.out.print("Introduce moneda a moneda el precio del producto: ");
                    double intro = sc.nextDouble();
                    
                    while(introducirDinero(intro) == 0) {
            			System.out.println("Dinero mal introducido, intentelo de nuevo");
            			intro = sc.nextDouble();
            		}
                    
                    while(intro < arrayComidaPrecio[codigo]) {
            			System.out.print("Debes meter mas monedas: ");
            			double intro2 = sc.nextDouble();
            			intro = intro + intro2;
            		}
					
                    int [] cambio = calcularCambio(intro, (arrayComidaPrecio[codigo] + calentarComida));
                    
                    double aux = 0;
            		for (int i = 0; i < cambio.length; i++) {
            			if (cambio[i] != 0) {
            				if(dinero[i] == 20.0 || dinero[i] == 10.0 || dinero[i] == 5.0) {
            					System.out.println("Te devolvemos " + cambio[i] + " billete de " + dinero[i] + " = " + (cambio[i] * dinero[i]));
                				aux = aux + (cambio[i] * dinero[i]);
            				} else {
            				System.out.println("Te devolvemos " + cambio[i] + " moneda de " + dinero[i] + " = " + (cambio[i] * dinero[i]));
            				aux = aux + (cambio[i] * dinero[i]);
            				}
            			}
					}
            		System.out.println("Has introducido " + Math.round(intro * 100d)/100d);
            		System.out.println("Te devolvemos: " + Math.round(aux * 100d)/100d);
					
                    comprarComida();

					//maquinaOperativa = false;
					seleccion = 0;
                    seleccion2 = 0;

					break;
				case 3:
					seleccion = 0;
					break;
				case 4:
					System.out.println("Hasta pronto!!");
					seleccion = 0;
					maquinaOperativa = false;
					break;
				}
			}
			while (seleccion == 2) {
				System.out.println("Has seleccionado Bebida");
				System.out.println("�Que quieres hacer ahora?");
				System.out.println("(1) Mostrar Bebida:");
				System.out.println("(2) Seleccionar c�digo:");
				System.out.println("(3) Atras:");
				System.out.println("(4) Salir:");
				int seleccion2 = sc.nextInt();
				switch (seleccion2) {
				case 1:
					System.out.println("Mostrar Bebida:");
					visualizarBebidas();
					break;
				case 2:
					System.out.println("Seleccionar codigo:");
					for (int i = 0; i < arrayBebidaCodigo.length; i++) {
						System.out.print(arrayBebidaCodigo[i] + ", ");
					}
					System.out.print("Selecciona tu codigo: ");
					String cod = sc.next();

					int codigo = seleccionarBebida(cod.charAt(0));

					System.out.println("Has seleccionado: " + arrayBebida[codigo] + " su precio es de "
							+ arrayBebidaPrecio[codigo]);

					if (arrayBebida[codigo].equalsIgnoreCase("Caf� solo")) {
						System.out.print("�Quieres azucar en el cafe? (Si/No)");
						String cafe = sc.next();
						if (cafe.equalsIgnoreCase("si")) {
							System.out.print("Perfecto, �cuanto azucar quieres? (5-Max)");
							int azucar = sc.nextInt();
							while (azucar > 5 || azucar < 0) {
								System.out.println("Lo siento, solo podemos ofrecerte maximo 5 de azucar");
								System.out.println("Intentelo otra vez: ");
								azucar = sc.nextInt();
							}
							System.out.println("Perfecto le a�adiremos " + azucar + " de azucar");
						
							
						}
					}

					System.out.println("Vamos a cobrarte:");
					System.out.print("Introduce moneda a moneda el precio del producto: ");
                    double intro = sc.nextDouble();
                    
                    while(introducirDinero(intro) == 0) {
            			System.out.println("Dinero mal introducido, intentelo de nuevo");
            			intro = sc.nextDouble();
            		}
                    
                    while(intro < arrayBebidaPrecio[codigo]) {
            			System.out.print("Debes meter mas monedas: ");
            			double intro2 = sc.nextDouble();
            			intro = intro + intro2;
            		}
                    

                    int [] cambio = calcularCambio(intro, arrayBebidaPrecio[codigo]);
                    double aux = 0;
            		for (int i = 0; i < cambio.length; i++) {
            			if (cambio[i] != 0) {
            				if(dinero[i] == 20.0 || dinero[i] == 10.0 || dinero[i] == 5.0) {
            					System.out.println("Te devolvemos " + cambio[i] + " billete de " + dinero[i] + " = " + (cambio[i] * dinero[i]) + " euros");
                				aux = aux + (cambio[i] * dinero[i]);
            				} else {
            				System.out.println("Te devolvemos " + cambio[i] + " moneda de " + dinero[i] + " = " + (cambio[i] * dinero[i]) + " centimos");
            				aux = aux + (cambio[i] * dinero[i]);
            				}
            			}
            		}
            		System.out.println("Has introducido " + df.format(intro));
            		System.out.println("Te devolvemos: " + df.format(aux));
					
					comprarBebida();
					
                    //maquinaOperativa = false;
                    seleccion2 = 0;
                    seleccion = 0;

					break;
				case 3:
					seleccion = 0;
					break;
				case 4:
					System.out.println("Hasta pronto!!");
					seleccion = 0;
					maquinaOperativa = false;
					break;
				}
			}
			while (seleccion == 3) {
				System.out.println("Hasta pronto!!");
				seleccion = 0;
				maquinaOperativa = false;
			}

		}
		sc.close();
	}

	public static int[] calcularCambio(double dineroIntroducido, double precio) {
		int[] cambio = new int[11];

		int cont = 0;

		DecimalFormat df = new DecimalFormat("#.00");
		

		//Introduce el dinero ejemplo 12,4�
		//El precio supongamos que es 2�
		//Hacemos la resta de 12,4 - 2 = 10,4�
		
		double vuelta = dineroIntroducido - precio;
		df.format(vuelta);

		//Como hacer que pare y vuelva a repetir
		
		for (int i = 0; i < cambio.length; i++) {
			for (int j = 0; j < dinero.length; j++) {
				if((vuelta - dinero[i]) >= 0) {
					vuelta = vuelta - dinero[i];
					cont++;
					cambio[i]= cont;
				}
			}
			cont = 0;
		}
		
		
		
		return cambio;
	}

	public static double introducirDinero(double num1) {
		
		for (int i = 0; i < dinero.length; i++) {
			if ( num1 == dinero[i]) {
				return num1;
			} 
		}
		
		return 0;
	}

	public static void visualizarBebidas() {
		for (int i = 0; i < arrayBebida.length; i++) {
			System.out.println("Nombre: " + arrayBebida[i] + " |Codigo: " + arrayBebidaCodigo[i] + " |Precio: "
					+ arrayBebidaPrecio[i] + "�|");
		}
	}

	public static void visualizarComida() {
		for (int i = 0; i < arrayComida.length; i++) {
			System.out.println("Nombre: " + arrayComida[i] + " |Codigo: " + arrayComidaCodigo[i] + " |Precio: "
					+ arrayComidaPrecio[i] + "�|");
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
