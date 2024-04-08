package InterfazImpl;

public class FabricaDeRuedas {

	public Rueda crearRueda(String tipo) {
		if(tipo.equalsIgnoreCase("Pirelli")) {
			Rueda rueda1 = new RuedaPirelli(0, 0);
			return rueda1;
		} else {
			Rueda rueda1 = new RuedaDunlop();
			return rueda1;
		}
	}
	
}
