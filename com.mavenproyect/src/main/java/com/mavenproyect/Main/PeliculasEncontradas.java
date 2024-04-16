package com.mavenproyect.Main;

import java.util.Arrays;
import java.util.List;

public class PeliculasEncontradas {

	private Peliculas[] encontrados;
	private List<Peliculas> Search;
    private String totalResults;
    private String Response;
	
	
	public List<Peliculas> getSearch() {
		return Search;
	}

	public void setSearch(List<Peliculas> search) {
		Search = search;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

	public Peliculas[] getEncontrados() {
		return encontrados;
	}

	public void setEncontrados(Peliculas[] encontrados) {
		this.encontrados = encontrados;
	}

	@Override
	public String toString() {
		return "PeliculasEncontradas [encontrados=" + Arrays.toString(encontrados) + ", Search=" + Search
				+ ", totalResults=" + totalResults + ", Response=" + Response + "]";
	}

	
	
	
	
}