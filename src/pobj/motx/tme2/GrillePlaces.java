package pobj.motx.tme2;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;

public class GrillePlaces{
	private List<Emplacement> places = new ArrayList<>(); //stocker les emplacements trouvés
	private int nbH=0; //nombre d’emplacements horizontaux 
	
	private List<Case> getLig(Grille g, int lig){
		List<Case> res = new ArrayList<Case>();
		for(int i=0; i<g.nbCol(); i++) {
			res.add(g.getCase(lig, i));
		}
		return res;
	} 
	
	private List<Case> getCol(Grille g, int col){
		List<Case> res = new ArrayList<Case>();
		for(int j=0; j<g.nbLig(); j++) {
			res.add(g.getCase(j, col));
		}
		return res;
	}
	
	private void cherchePlaces(List<Case> cases) { //au moins 2 cases non pleines
		Emplacement emp= new Emplacement();
		for (Case c : cases) {	
			if (!c.isPleine()) {
				emp.add(c); //ou .cases?
			}else { //examinons la taille de l’emplacement construit
				if (emp.size() >= 2){
					places.add(emp); //nous l’ajoutons aux emplacements de mot détectés,
				}
				emp=new Emplacement();
			}
		}if (emp.size() >= 2){
			this.places.add(emp); //nous l’ajoutons aux emplacements de mot détectés,
		}
	}
	
	public GrillePlaces(Grille grille) {
		for (int i=0; i<grille.nbLig(); i++) {
			cherchePlaces(getLig(grille, i)); //chercher les emplacements de mot
			// noter le nombre d’emplacements horizontaux détectés?
		}
		nbH=places.size();
		for (int j=0; j<grille.nbCol(); j++) {
			cherchePlaces(getCol(grille, j));
		}	
	}
	
	public List<Emplacement> getPlaces() {
		return places;
	}
	
	public int getNbHorizontal() {
		return nbH;
	}
	
	public String toString() {
		int i=0;
		String res="";
		for (Emplacement emp : places) { 
			res+=emp.getCase(i).getChar();
			i++;
		}
		return res;
	}
	
	public GrillePlaces fixer(int m, String soluce) {
		GrillePlaces res = this;
		for (int i=0; i<res.places.get(m).size(); i++) {
			res.places.get(m).getCase(i).setChar(soluce.charAt(i));
			  //emplacement    //case 
		}
		
		return res;
		
	}
	
	
	

	
}
