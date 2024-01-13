package lagunaJuego.Monstruos;

public class EsbirrosAltoNivel extends Monstruos {

	String nombre;
	String tipo = "EsbirroAlto";
	int vida = 400;
	int armadura = 30;
	int mana = 50;
	int ataque = 50;
	
	public EsbirrosAltoNivel(String nombre, String tipo, int vida, int armadura, int mana, int ataque) {
		super(nombre, tipo, vida, armadura, mana, ataque);
		
	}
	
	@Override
	public void presentacion() {
		System.out.println("Este será tu fin asqueroso humano");
	}

	// Los esbirros solo tienen una tirada de dados, dependiendo del numero tienen otra tirada mas
	// Tienen poco daño un poco mas que los esbirros normales y poca vida pero mas que los normales
	// Tienen poca mana pero mas que los normales

}
