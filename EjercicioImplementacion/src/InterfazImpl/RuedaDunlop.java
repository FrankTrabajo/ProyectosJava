package InterfazImpl;

public class RuedaDunlop implements Rueda {

	int aireRueda = 0;
	int vueltas = 0;
	
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
		//Una rueda para que de una vuelta es 2m es una vuelta
		//La velocidad se mide en km/h
		//1 vuelta --- 2m
		//x vueltas ---- 1km = 1000 == 500 vueltas
		//dada la velocidad se calcula cuantas vueltas ha dado la rueda
		this.vueltas = velocidad / 2;
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
		return "RuedaDunlop [aireRueda=" + aireRueda + ", vueltas=" + vueltas + "]";
	}

	
	
	

}
