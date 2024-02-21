package com.testng.selenium.v1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
        // Crear una instancia de WebDriver (aquí necesitas inicializar tu WebDriver)
        WebDriver driver = initializeWebDriver();

        // Crear una instancia de la clase Descarga2Febrero
        Descarga2Febrero descarga = new Descarga2Febrero();

        // Llamar al método descarga2febrero con los parámetros necesarios
        descarga.descarga2febrero("14", "02", driver);

        // Cerrar el navegador al finalizar
        driver.quit();
    }

    // Método para inicializar el WebDriver (aquí necesitas implementar la inicialización de tu WebDriver)
    private static WebDriver initializeWebDriver() {
        // implementa la inicialización de tu WebDriver
        return null;
    }
}

class Descarga2Febrero {
    public void descarga2febrero(String startDate, String month, WebDriver driver) {
        LocalDate fechaActual = LocalDate.now();
        int mes = Integer.parseInt(month);
        LocalDate fechaMesAnterior = fechaActual.minusMonths(1);
        String mesAnterior = fechaMesAnterior.getMonth().getDisplayName(java.time.format.TextStyle.FULL, new Locale("es", "ES"));
        int anioAnterior = fechaMesAnterior.getYear();
        String resultado = mesAnterior.toUpperCase() + " " + anioAnterior;

        try {
            // Comando para abrir Google Chrome desde WSL
            String command = "cmd.exe /c start wsl google-chrome https://sede.madrid.es/portal/site/tramites/menuitem.944fd80592a1301b7ce0ccf4a8a409a0/?vgnextoid=741d814231ede410VgnVCM1000000b205a0aRCRD&vgnextchannel=741d814231ede410VgnVCM1000000b205a0aRCRD&vgnextfmt=default";
            Process process = Runtime.getRuntime().exec(command);

            System.out.println("CMD de Windows y Google Chrome se están abriendo desde Java...");
        } catch (IOException e) {
            System.out.println("Error al intentar abrir CMD de Windows y Google Chrome desde Java: " + e.getMessage());
        }

        driver.get("https://www.madrid.es/portal/site/munimadrid");
        // driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.id("iam-cookie-control-modal-action-primary")).click();
        driver.findElement(By.id("searcher-toggle-button")).click();
        driver.findElement(By.id("search-field")).sendKeys("boam");
        driver.findElement(By.id("search-field")).submit();
        driver.findElement(By.id("Layer_1")).click();
        driver.findElement(By.linkText("Boletín Oficial del Ayuntamiento")).click();
        driver.findElement(By.id("Layer_1")).click();
        WebElement enlace = driver.findElement(By.xpath("//a[@title='"+ resultado +"' and text()='«']"));
        if(fechaActual.getMonthValue() > mes) {
            enlace.click();
        }

    }




}
