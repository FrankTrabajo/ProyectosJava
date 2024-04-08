package tres_en_raya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Persona {
	
	private Map<Integer, String> miMapa = new HashMap<Integer, String>();
	private List<String> miLista = new ArrayList<String>();
	private Set<String> miSet = new HashSet<String>();
	
	public void addMap(String elem) {
		miMapa.put(elem.length(), elem);
	}
	public void addList(String elem) {
		miLista.add(elem);
	}
	public void addSet(String elem) {
		miSet.add(elem);
	}
	public void numElems() {
		System.out.println("Elementos Mapa:" + miMapa.size());
		System.out.println("Elementos Lista:" + miLista.size());
		System.out.println("Elementos Set:" + miSet.size());
	}
	public static void main(String[] args) {
		Persona p = new Persona();
		List<String> nombre = Arrays.asList("pedro","lola", "paco", "pedro", "marta");
		for (String string : nombre) {
			p.addMap(string);
			p.addList(string);
			p.addSet(string);		
		}
		p.numElems();

	}
	

}
