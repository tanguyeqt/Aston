package fr.exemple;

public class Chat {
		private static String nom;
		private int poids;
		private static int nbPattes;
		
	
		public Chat(String nom, int poids){
			this.nom = nom;
			this.poids = poids;
			this.nbPattes = nbPattes;
			
			
			
			}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public int getPoids() {
			return poids;
		}


		public void setPoids(int poids) {
			this.poids = poids;
		}
		
		public boolean faireQQChose(int unParam) {
			if(unParam ==0) {
				return false;
			}
			return true;
		}
		
		public static int getNbPattes() {
			System.out.println(nom);
			return nbPattes;
		}
		
	public static void setNbPattes(int nbPattes) {
		Chat.nbPattes = nbPattes;
	}
		
		public static void main(String[] args) {
			Chat c = new Chat("Samy", 10);
			System.out.println(c.getNom());
			System.out.println(Chat.getNbPattes());
			
			Chat c2 = new Chat("Albert", 10);
			c2.nbPattes = 3;
			System.out.println(Chat.nbPattes);
			System.out.println(Chat.nbPattes);
			Chat.setNbPattes(89);

			
		}
		
}
