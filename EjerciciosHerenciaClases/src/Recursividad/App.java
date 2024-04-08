package Recursividad;

public class App {

	
    public static void main(String[] args) throws Exception {
        System.out.println(numeroAlReves("584"));
        
        numeroAlReves2(584);

    }


    public static int sumaNumero(int n){
        // devuelve la suma de los n primeros numeros       
        // caso base n = 0
        if(n == 0){
            return 0;
        }
        else {
            return n + sumaNumero(n-1);
        }
    }

    public static int factorial(int n){
        // devuelve la multiplica de los n primeros numeros       
        // caso base n = 0
        if(n == 0){
            return 1;
        }
        else {
            // llamamos al metodo "n - 1"
            return n * factorial(n- 1);
        }
    }

    public static int sumaPares(int n1, int n2){
        // caso base 
        if(n1 == n2){
            return n1;
        }
        else {
            // llamamos al metodo "n - 1"
            return n2 + sumaPares(n1, n2 -2);
        }
    }


    public static int fibonacci(int n){

        // caso base n = 1 o n = 2
        if(n == 1 || n == 2){
            return 1;
        }
        else{
        // sino f(n) = f(n-1) + f(n-2)
            return fibonacci(n- 1) + fibonacci(n-2);
        }

    }

    public static boolean palindromo(String palabra){

        if (palabra.length() <= 1) {
            return true;
        }
        else{
            char primero = palabra.charAt(0);
            char ultimo = palabra.charAt(palabra.length() - 1);

            if (primero == ultimo){
                String palabraCorta = 
                        palabra.substring(1, palabra.length() -1); 
                return palindromo(palabraCorta);
            }
            else{
                return false;
            }
        }




    }


    public static int numeroAlReves(int numero){
        // CC
        if (numero < 10){
            return numero;
        }
        else{
            int nCifras = calcularNumeroCifras(numero);
            return (int)Math.pow(10, nCifras - 1)* (numero % 10)  
            +  numeroAlReves(numero/10);
        }
    }

    public static int calcularNumeroCifras(int numero){
        int contador = 1;
        while(numero > 10){
            contador++;
            numero = numero / 10;
        }
        return contador;
    }

    public static String numeroAlReves(String numero){
        // CC
        int num = Integer.parseInt(numero);
        if (num < 10){
            return numero;
        }
        else{
            int n2 = num/10;
            String n3 = String.valueOf(n2);
            return (num % 10)  +  numeroAlReves(n3);
        }
    }

    public static void numeroAlReves2(int numero){    
        if (numero < 10){
            System.out.print(numero);
        }
        else{
            System.out.print(numero%10);
            numeroAlReves2(numero/10);
        }
    }
}

