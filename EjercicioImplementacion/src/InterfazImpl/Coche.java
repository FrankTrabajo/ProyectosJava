package InterfazImpl;

import java.util.Arrays;

public class Coche {
	
	String marca;
	String modelo;
	String color;
	int puertas;
	Rueda[] ruedas = new Rueda[4];
	
	public Coche(String marca, String modelo, String color, int puertas, Rueda[] ruedas) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.puertas = puertas;
		this.ruedas = ruedas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public Rueda[] getRuedas() {
		return ruedas;
	}

	public void setRuedas(Rueda[] ruedas) {
		this.ruedas = ruedas;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", puertas=" + puertas
				+ ", ruedas=" + Arrays.toString(ruedas) + "]";
	}
	
	
	
}
