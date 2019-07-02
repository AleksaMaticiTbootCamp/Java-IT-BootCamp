package picerija;

import java.util.Scanner;

public class ProblemSpecijalnihPopusta {

	public static void main(String[] args) {

		int gratisBrojac = 1;
		int brojMusterije = 1;

		System.out.print("Dobrodosli u Brasko++ pametnu kasu!\nKoji je danas dan (Pon/Uto/Sre/Cet/Pet/Sub/Ned): ");

		Scanner sc = new Scanner(System.in);

		int dan = 0;
		while (dan == 0) {
			String unos = sc.next();
			switch (unos) {
			case "Pon":
				dan = 1;
				break;
			case "Uto":
				dan = 2;
				break;
			case "Sre":
				dan = 3;
				break;
			case "Cet":
				dan = 4;
				break;
			case "Pet":
				dan = 5;
				break;
			case "Sub":
				dan = 6;
				break;
			case "Ned":
				dan = 7;
				break;
			default:
				System.out.print("Greska u unosu. Pokusajte ponovo: ");
				continue;
			}
		}

		System.out.print("Musterija %" + brojMusterije + "#: ");

		int brojPizza = sc.nextInt();

		while (brojPizza != -1) {
			int total = 0;
			int totalPopust = 0;

			String racun = "- Racun za musteriju id#" + brojMusterije++ + " - \n"; //??

			for (int i = 0; i < brojPizza; i++) {
				int narudzbina = sc.nextInt();

				String imePizze = "";
				int cenaPizze = 0;
				switch (narudzbina) {
				case 2:
					imePizze = "Capricciosa";
					cenaPizze = 320;
					break;
				case 3:
					imePizze = "Pepperoni";
					cenaPizze = 290;
					break;
				case 5:
					imePizze = "Vesuvio";
					cenaPizze = 310;
					break;
				}

				if (gratisBrojac != 0 && gratisBrojac % 7 == 0)
					racun += "AKCIJA #7 " + imePizze + " 0\n";

				if (i == 0 || i % 3 != 0) {
					total += cenaPizze;

					if ((dan == 2 && narudzbina == 5) || (dan == 4 && narudzbina == 2)) {
						totalPopust += (cenaPizze * 10) / 100;
					} else if (dan >= 6) {
						totalPopust += (cenaPizze * 15) / 100;
					}
					racun += "Pizza " + imePizze + " " + cenaPizze + '\n';
				} else {
					racun += "AKCIJA 3+1 " + imePizze + " 0\n";
				}

				gratisBrojac++;
			}

			if (totalPopust > 0) {
				racun += "\tukupno " + total + '\n';

				switch (dan) {
				case 2:
					racun += "10% Vesuvio";
					break;
				case 4:
					racun += "10% Capricciosa";
					break;
				case 6: // ??
				case 7:
					racun += "15% na sve pizze";
					break;
				}
				racun += " \t" + totalPopust + '\n';

				total -= totalPopust;
			}
			racun += "\tukupno " + total + "\n---------------------------";

			System.out.println(racun);

			brojPizza = sc.nextInt();
		}
	}

}
 