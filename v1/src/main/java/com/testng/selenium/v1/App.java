package com.testng.selenium.v1;

import java.io.IOException;

public class App {

	public static void main(String[] args) {

		try {
			// Comando para abrir Google Chrome desde WSL
			String command = "cmd.exe /c start wsl google-chrome-stable https://sede.madrid.es/portal/site/tramites/menuitem.944fd80592a1301b7ce0ccf4a8a409a0/?vgnextoid=741d814231ede410VgnVCM1000000b205a0aRCRD&vgnextchannel=741d814231ede410VgnVCM1000000b205a0aRCRD&vgnextfmt=default";
			Process process = Runtime.getRuntime().exec(command);

			System.out.println("Google Chrome se está abriendo desde Java en Ubuntu...");
		} catch (IOException e) {
			System.out.println("Error al intentar abrir Google Chrome desde Java en Ubuntu: " + e.getMessage());
		}

	}

}
