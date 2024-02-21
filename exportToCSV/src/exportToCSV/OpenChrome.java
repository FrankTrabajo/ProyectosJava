package exportToCSV;

import java.io.IOException;

public class OpenChrome {
	public static void main(String[] args) throws InterruptedException {
        try {
        	// Comando para abrir WSL desde el CMD de Windows
            String command = "cmd.exe /c start wsl google-chrome";
            Process process = Runtime.getRuntime().exec(command);

            
            
            System.out.println("CMD de Windows y Google Chrome se están abriendo desde Java...");
        } catch (IOException e) {
            System.out.println("Error al intentar abrir CMD de Windows y Google Chrome desde Java: " + e.getMessage());
        } /*catch (InterruptedException e) {
            System.out.println("Error al esperar a que se abra CMD de Windows y Google Chrome desde Java: " + e.getMessage());
        }*/
    }
}
