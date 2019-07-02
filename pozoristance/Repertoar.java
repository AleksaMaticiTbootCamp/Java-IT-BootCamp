package pozoristance;

import java.util.LinkedList;
import java.util.List;

public class Repertoar {

	private Pozoriste pozoriste;
	private List<Predstava> predstave;

	public Repertoar(Pozoriste pozoriste) {
		this.pozoriste = pozoriste;
		this.predstave = new LinkedList<Predstava>();
	}

	public void dodaj(Predstava predstava) {
		predstave.add(predstava);
	}

	public void ukloni(String imePredstave) {
		for (int i = 0; i < predstave.size(); i++) {
			if (predstave.get(i).getNaziv().equals(imePredstave)) {
				predstave.remove(i);
			}
		}
	}

	public String toString() {
		String ispis = pozoriste.getNaziv() + ": [\n";
		for (int i = 0; i < predstave.size(); i++) {
			ispis += "  " + predstave.get(i).toString() + "\n";
		}
		ispis += "]";
		return ispis;
	}
}
