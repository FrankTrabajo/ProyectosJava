package lagunaJuego.Monstruos;

public class Esbirros extends Monstruos {

	String nombre;
	String tipo = "Esbirros";
	int vida = 200;
	int armadura = 10;
	int mana = 30;
	int ataque = 30;
	
	public Esbirros(String nombre, String tipo, int vida, int armadura, int mana, int ataque) {
		super(nombre, tipo, vida, armadura, mana, ataque);
		
	}
	
	//Los esbirros solo tienen una tirada de dados
	//Tienen poco daño y poca vida
	//Tienen poca mana

}
