package InterfazImpl;

public class RuedaPirelli implements Rueda{

	int aireRueda = 0;
	int vueltas = 0;
	
	public RuedaPirelli(int aireRueda, int vueltas) {
		super();
		this.aireRueda = aireRueda;
		this.vueltas = vueltas;
	}

	public int getAireRueda() {
		return aireRueda;
	}

	public void setAireRueda(int aireRueda) {
		this.aireRueda = aireRueda;
	}

	public int getVueltas() {
		return vueltas;
	}

	public void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	@Override
	public void rodar(int velocidad) {
		//1 vuelta es 1,95 metros
		this.vueltas = (int) (velocidad / 1.95);
		System.out.println("Esta rueda ha dado: " + this.vueltas);
		if(this.vueltas > 200) {
			this.aireRueda = this.aireRueda - 100;
		}
	}

	@Override
	public void inflar() {
		if(this.aireRueda < 2500) {
			System.out.println("Se necesita inflar la rueda");
			this.aireRueda = 2500;
		}
		
	}

	@Override
	public void instalar() {
		if(this.aireRueda >= 2500) {
			System.out.println("Se puede instalar la rueda");
			System.out.println("Rueda instalada");
		} else {
			inflar();
		}
		
	}

	
	@Override
	public String toString() {
		return "RuedaPirelli [aireRueda=" + aireRueda + ", vueltas=" + vueltas + "]";
	}



	

}
