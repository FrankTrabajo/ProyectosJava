package elSeniorDelLosAnillos;

public class Bestias {


	String nombre;
	int vida;
	int armadura;
	
	

	public Bestias(String nombre, int vida, int armadura) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.armadura = armadura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public void ataque(int damage) {
        int daño = Math.max(damage - armadura, 0);
        vida -= daño;
        System.out.println(nombre + " recibe " + daño + " puntos de daño.");
    }
	
	
	public void presentacion() {
		System.out.println("Sonido de las bestias");
	}

	@Override
	public String toString() {
		return "Bestias [nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + "]";
	}
	
	
	
}

