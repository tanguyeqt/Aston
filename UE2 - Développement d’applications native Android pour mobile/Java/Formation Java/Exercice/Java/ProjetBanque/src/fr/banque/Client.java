package fr.banque;

import java.util.Arrays;

public class Client {

	
		private String nom;
		private String prenom;
		private int age;
		private int numero;
		private Compte[] tabComptes;
		
				public Client() {
				this(0, null, null, 0);
			}
		

		public Client(int age, String prenom, String nom, int numero) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.numero = numero;
			this.tabComptes = new Compte[5];
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		public int getNumero() {
			return numero;
		}


		public void setNumero(int numero) {
			this.numero = numero;
		}


		public Compte[] getTabComptes() {
			return tabComptes;
		}


		public void setTabComptes(Compte[] tabComptes) {
			this.tabComptes = tabComptes;
		}

		public void ajouterCompte(Compte unCompte) {
			boolean ajoute = false;
			
			for (int i = 0; !ajoute && i < this.tabComptes.length; i++) {
					
			if (this.tabComptes[i] == null) {						
				this.tabComptes[i] = unCompte;
				ajoute = true;
					}
			}
			
			if (!ajoute) {
					throw new IllegalArgumentException("Plus de place dans le tableau");
				}
			}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
		
			s.append(" Nom: ");
			s.append(this.getNom());
			s.append(" Prenom: ");
			s.append(this.getPrenom());
			s.append(" Age: ");
			s.append(this.getAge());
			s.append("\n");
			for (int i = 0; i < this.tabComptes.length; i++) {
				if (this.tabComptes[i] != null) {
					s.append(this.tabComptes[i]);
					s.append("\n");
				}
			}
			return s.toString();
		}



		


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Client other = (Client) obj;
			if (age != other.age)
				return false;
			if (nom == null) {
				if (other.nom != null)
					return false;
			} else if (!nom.equals(other.nom))
				return false;
			if (numero != other.numero)
				return false;
			if (prenom == null) {
				if (other.prenom != null)
					return false;
			} else if (!prenom.equals(other.prenom))
				return false;
			if (!Arrays.equals(tabComptes, other.tabComptes))
				return false;
			return true;
		}
		
		
		
		
		
	
	
	
}
