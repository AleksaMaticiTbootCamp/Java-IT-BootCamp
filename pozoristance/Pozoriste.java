 	package pozoristance;

public class Pozoriste {

		private int id;
		private String naziv;
		private static int uid = 0;
		
		public Pozoriste (String naziv) {
			this.naziv = naziv;
			id = uid++;
			}
		
		public int getId() {
			return id;
		}

		public String getNaziv() {
			return naziv;
		}
		public String getSkraceno() {
			String pomocni = "";
			for(String rec: naziv.split(" ")) {
				pomocni += rec.charAt(0);
			}
			return pomocni.toUpperCase();
		}

		@Override
		public String toString() {
			return naziv + " [" + id + "]";
		}
}
