package com.mavenproyect.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlmacenDePeliculasSQL {
	private static final String URL = "jdbc:sqlite:peliculasHarryPotter.db";

	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
	
	public static void almacenar(List<Peliculas> peliculas) {
		//INSERTAR EN LA BASE DE DATOS LOS DATOS DE LAS PELICULAS RECIBIDAS
		String insert = "INSERT INTO Pelicula (ImdbID, Titulo, Año, Poster, Valoracion) VALUES (?,?,?,?,1)";
		//CONTAR CUANTOS DATOS HAY EN NUESTRA BASE DE DATOS
		String select = "SELECT COUNT(*) FROM pelicula WHERE ImdbID = ?";


	    try (Connection conexion = getConnection();
	    		//STATEMENT RECOGERÁ LA ORDEN DE INSERCION EN NUESTRA BASE DE DATOS
	    	PreparedStatement statement = conexion.prepareStatement(insert);
	    		//STATEMENT SELECT RECOGERÁ LA ORDEN DE CONTAR CUANTOS DATOS TENEMOS EN LA BASE DE DATOS
	    	PreparedStatement statementSelect = conexion.prepareStatement(select)) {

	        for (Peliculas pelicula : peliculas) {
	        	//VERIFICA SI LA PELICULA YA EXISTE EN LA BASE DE DATOS
	        	statementSelect.setString(1, pelicula.getImdb());
	        	ResultSet resultSet = statementSelect.executeQuery();
	            resultSet.next();
	            //COUNT YA VALE 1 CON ESO NOS BASTA
	            int count = resultSet.getInt(1);
	            resultSet.close();
	        	
	            //SI COUNT VALE 0 SE ALMACENAN LOS DATOS EN LA BASE DE DATOS, SINO NO HACE NADA
	            if(count == 0) {
	            	statement.setString(1, pelicula.getImdb());
		            statement.setString(2, pelicula.getTitulo());
		            statement.setString(3, pelicula.getAnio());
		            statement.setString(4, pelicula.getImagen());
		            statement.executeUpdate();
	            }
	            
	        }   

	        System.out.println("LAS PELICULAS SE HAN ALMACENADO CORRECTAMENTE");

	    } catch (SQLException e) {
	    	System.err.println("ERROR AL ALMACENAR EN LA BASE DE DATOS");
	        System.err.println(e);
	    }
	}

	
	
}
