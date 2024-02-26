package InterfazImpl;

public class EjemploCoche {

	public static void main(String[] args) {
		
		FabricaDeRuedas fb = new FabricaDeRuedas();
		Rueda rueda1 = fb.crearRueda("Pirelli");
		Rueda rueda2 = fb.crearRueda("Pirelli");
		Rueda rueda3 = fb.crearRueda("Pirelli");
		Rueda rueda4 = fb.crearRueda("Pirelli");
		Rueda ruedad1 = fb.crearRueda("Dunlop");
		Rueda ruedad2 = fb.crearRueda("Dunlop");
		Rueda ruedad3 = fb.crearRueda("Dunlop");
		Rueda ruedad4 = fb.crearRueda("Dunlop");
		Rueda rueda5 = new RuedaPirelli(2600, 34);
		Rueda[] ruedasC1 = {rueda1, rueda2, rueda3, rueda4};
		Rueda[] ruedasC2 = {ruedad1, ruedad2, rueda5, ruedad4};
		Coche c2 = new Coche("Ford", "Focus", "Rojo", 4, ruedasC2);
		System.out.println(c2.toString());
		for (int i = 0; i < ruedasC2.length; i++) {
			System.out.print("Rueda " + i + ": " + ruedasC2[i].toString() + " ");
			ruedasC2[i].instalar();
		}
		Coche c1 = new Coche("Ford", "Fiesta", "Verde", 4, ruedasC1);

		System.out.println(c2.toString());
	}

}
