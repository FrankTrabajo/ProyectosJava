package com.mavenproyect.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;



public class App {
	public static void main(String[] args) {
		HttpClient htpc = HttpClients.createDefault();
		
		try {
         
            String apiUrl = "http://www.omdbapi.com/?apikey=731e41f&s=Harry+Potter&r=json";
            HttpGet httpGet = new HttpGet(apiUrl);
            
            HttpResponse response = htpc.execute(httpGet);
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                
                
                String jsonString = stringBuilder.toString();
                
                JSONObject jsobject = new JSONObject(jsonString);
                JSONArray jsonArray = jsobject.getJSONArray("Search");
                ArrayList<Peliculas> lista = new ArrayList<Peliculas>();
                
                if(jsonArray != null) {
                	for (int i = 0; i < jsonArray.length(); i++) {
                		JSONObject peliculaJSON = jsonArray.getJSONObject(i);
                		String imdbID = peliculaJSON.getString("imdbID");
                		String titulo = peliculaJSON.getString("Title");
                		String anio = peliculaJSON.getString("Year");
                		String poster = peliculaJSON.getString("Poster");
                		
                		Peliculas peli = new Peliculas(imdbID,titulo,anio,poster);
                		lista.add(peli);
                		
					}
                }
                
                for (Peliculas pelicula : lista) {
                    System.out.println("imdbID: " + pelicula.getImdb());
                    System.out.println("Titulo: " + pelicula.getTitulo());
                    System.out.println("Año: " + pelicula.getAnio());
                    System.out.println("Poster: " + pelicula.getImagen());
                    System.out.println("Valoracion: " + pelicula.getValoracion());
                    System.out.println();
                }
                
                //Almaceno las peliculas en mi Base de Datos
                AlmacenDePeliculasSQL.almacenar(lista);


                reader.close();
                inputStream.close();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}