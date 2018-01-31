package fr.Run;
import fr.banque.*;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client client = new Client(20, "Equinet", "Tanguy", 28);
		
		Compte c1 = new Compte( 56666 , 56);
		
		client.ajouterCompte(c1);
		
		System.out.println(client);
			
	
		
	}

}
