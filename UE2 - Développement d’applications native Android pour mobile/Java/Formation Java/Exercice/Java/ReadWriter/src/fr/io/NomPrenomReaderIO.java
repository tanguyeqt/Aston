package fr.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NomPrenomReaderIO {

	private static String ROOT;

	private static final String FICHIER_NOM = "nom.txt";

	private static final String FICHIER_PRENOM = "prenom.txt";

	
	public static void setROOT(String aRoot) {
		NomPrenomReaderIO.ROOT = aRoot;
	}

	
	private static List<String> readFichier(String unNomDeFichier) throws IOException {
		File fichierNom = new File(NomPrenomReaderIO.ROOT, unNomDeFichier);
		if (!fichierNom.exists() || !fichierNom.canRead()) {
			throw new IOException("Probleme d'acces au fichier " + fichierNom);
		}
		List<String> resultat = new ArrayList<String>();
		
		try (FileReader fileReader = new FileReader(fichierNom);
				BufferedReader buffered = new BufferedReader(fileReader)) {
			String ligne;
			do {
				ligne = buffered.readLine();
				ligne = ligne != null ? ligne.trim() : null;
				if (ligne != null && !ligne.isEmpty()) {
					resultat.add(ligne);
				}
			} while (ligne != null);
		} catch (Exception e) {
			
			throw new IOException("Erreur lors de la lecture du fichier " + fichierNom, e);
		}
		
		return resultat;
	}

	
	public static List<String> readNom() throws IOException {
		return NomPrenomReaderIO.readFichier(NomPrenomReaderIO.FICHIER_NOM);
	}

	
	public static List<String> readPrenom() throws IOException {
		return NomPrenomReaderIO.readFichier(NomPrenomReaderIO.FICHIER_PRENOM);
	}
}
