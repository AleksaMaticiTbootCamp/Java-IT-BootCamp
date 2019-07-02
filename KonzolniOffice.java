import java.util.Scanner;

public class KonzolniOffice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] niz = new String[100];
		int duzina = 0;
		String recenica = s.nextLine(); // Next -> "Ala je lep" = "ALA" ; Nextline() = "Ala je lep" duu

		System.out.println("Dobrodošli u konzolni WordTM!");
		System.out.println("----------------------------");
		isprintajMeni();

		System.out.println("----------------------------");
		int kom = 0;

		while (kom != -1) {
			System.out.print("komanda: ");
			kom = s.nextInt();
			switch (kom) {
			case -1:
				break;
			case 0:int indeks = s.nextInt(); duzina = obrisiRecenicu(niz, duzina, indeks);
			case 1:
				duzina = dodajRecenicu(niz, duzina, recenica);
				break;
			case 2:
				duzina = dodajBlok(niz, duzina, recenica);
			case 3: //
			case 4:
				System.out.println(niz);
			case 99:
				isprintajMeni();
				break;
			default:
				System.out.println("Greska u izboru komande");
			}
		}
	}

	public static void isprintajMeni() {
		System.out.println(
				"-1) Izlaz iz programa\n" + " 0) Obrisi recenicu\n" + " 1) Dodaj Recenicu\n" + " 2) Dodaj blok teksta\n"
						+ " 3) Izmeni rečenicu\n" + " 4) Ispis celog teksta\n" + " 99) Ispis komandnog menija");
	}

	public static int dodajRecenicu(String[] niz, int duzina, String recenica) {

		niz[duzina++] = recenica;
		return duzina;

	}

	public static int dodajBlok(String[] niz, int duzina, String tekst) {
		String[] recenice = tekst.split("[.!?]");
		for (int i = 0; i < recenice.length; i++) {
			niz[duzina++] = recenice[i];
		}
		return duzina;

	}

	public static int obrisiRecenicu(String[] niz, int duzina, int indeks) {
		for (int i = indeks; i < duzina; i++) {
			niz[i] = niz[i + 1];
		}
		return --duzina;

	}

}
