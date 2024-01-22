package lagunaJuego.Monstruos;

public class Monstruos {

	public String nombre;
	public String tipo;
	public int vida;
	public int armadura;
	public int mana;
	public int ataque;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	
	public void danioRecibido(int damage) {
		int daño = damage - armadura;
		vida -= daño;
		System.out.println(nombre + " recibe " + daño + " puntos de daño");
	}
	
	public void presentacion() {
		//Aqui se presenta el personaje
	}
	
	
}
