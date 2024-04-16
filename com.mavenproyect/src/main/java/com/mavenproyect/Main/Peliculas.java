package com.mavenproyect.Main;

import com.google.gson.annotations.SerializedName;

public class Peliculas {

	@SerializedName("imdbID")
	private String imdbID;
	@SerializedName("Title")
	private String titulo;
	@SerializedName("Year")
	private String anio;
	@SerializedName("Poster")
	private String imagen;
	@SerializedName("imdbID")
	private int valoracion;
	
	
	public String getImdb() {
		return imdbID;
	}
	public void setImdb(String imdb) {
		this.imdbID = imdb;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public String toString() {
		return "Pelicula [imdb=" + imdbID + ", titulo=" + titulo + ", anio=" + anio + ", imagen=" + imagen
				+ ", valoracion=" + valoracion + "]";
	}
	public Peliculas(String imdbID, String titulo, String anio, String imagen) {
		super();
		this.imdbID = imdbID;
		this.titulo = titulo;
		this.anio = anio;
		this.imagen = imagen;
	}
	
	
	
}
