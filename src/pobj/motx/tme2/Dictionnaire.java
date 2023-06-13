package pobj.motx.tme2;

import java.util.ArrayList;

import java.util.List;
import java.io.*;


/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();
	
	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len la longueur voulue 
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	
	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico=new Dictionnaire();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { 
			for (String line = br.readLine() ; line != null ; line = br.readLine() ) {
				// Utiliser "line".
				dico.mots.add(line);
			}
		} catch (IOException e) { 
			// Problème d’accès au fichier.
			e.printStackTrace(); 
		}
		return dico;
	}
	
	public int filtreParLettre(char c, int i) {
		
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String s : mots) {//garder que les mots dont la i ème lettre est égale au caractère de c
			if (s.charAt(i)==c)
				cible.add(s);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}
	
	public EnsembleLettre calculEL(int i) { //méthode envisageable pour calculer l’EnsembleLettre possible à une 
		                                    //position donnée (i.e. pour calculer l1 et l2).
		EnsembleLettre res = new EnsembleLettre();
		for (String mot : mots) {
			if ( !res.contains(mot.charAt(i)) ) {
				res.add(mot.charAt(i));
			}	
		}return res;
	}
	
	public int filtreEL(EnsembleLettre lp, int i) { // tester pour chaque mot que lp contient bien la
		                                                     //lettre d’indice ind du mot
		
		//return dico.filtreParLettre(lp.get(i).charValue(), i);
		
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (lp.contains(mot.charAt(i)) )
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
		
	}
		
}
	

