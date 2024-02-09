package com.testng.selenium.v1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	    // Establecer la propiedad del sistema para el ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application/new_chromedriver.exe");

	    // Inicializar ChromeDriver
	    WebDriver driver = new ChromeDriver();

	    // Navegar a la página de Google
	    driver.get("https://www.google.com/?hl=es");

	    // Encontrar el campo de búsqueda de Google
	    WebElement searchBox = driver.findElement(By.name("q"));

	    // Ingresar la búsqueda "Los 40 principales" en el campo de búsqueda
	    searchBox.sendKeys("Los 40 principales");

	    // Enviar el formulario de búsqueda
	    searchBox.submit();

	    // Esperar un momento para que aparezcan los resultados de búsqueda
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    // Encontrar y hacer clic en el enlace de Los 40 principales
	    WebElement los40Link = driver.findElement(By.partialLinkText("Los 40 principales"));
	    los40Link.click();

	    // Esperar un momento para que la página de Los 40 principales cargue completamente
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    // Imprimir el título de la página actual
	    System.out.println("Título de la página: " + driver.getTitle());

	    // Cerrar el navegador
	    driver.quit();
	}


}
