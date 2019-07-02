package pozoristance;

public abstract class Zaposleni {

	private String ime;
	private Pozoriste pozoriste;

	public Zaposleni(String ime, Pozoriste p) {
		this.ime = ime;
		this.pozoriste = p;

	}

	public String getIme() {
		return ime;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}
	
	public abstract String imePosla();

	@Override
	public String toString() {
		return  ime + "(" + imePosla() + ", " + pozoriste.getSkraceno() + ")";
	}
	
	
	
}
