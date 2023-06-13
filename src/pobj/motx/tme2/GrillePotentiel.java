package pobj.motx.tme2;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;


public class GrillePotentiel{
	private GrillePlaces grillea;//grille actuelle partiellement remplie
	private Dictionnaire dico; //stocke le dictionnaire français complet
	private List<Dictionnaire> motsPot;//domaine de chaque emplacement
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grillea=grille;
		this.dico=dicoComplet;
		motsPot=new ArrayList<>();
		
		for (int i=0; i<grillea.getPlaces().size();i++) { //parcours d'emplacements
			Dictionnaire dicomot = dico.copy(); 
			
			// limiter les mots en filtrant le dictionnaire par longueur
			dicomot.filtreLongueur(grillea.getPlaces().get(i).size());
			
			for (int j=0; j<grillea.getPlaces().get(i).size(); j++) {//parcours des cases de l'emplacement
				
				Case c = grillea.getPlaces().get(i).getCase(j);
				if ( ! c.isVide() ) {
					dicomot.filtreParLettre(c.getChar(), j);	
				}
			}motsPot.add(dicomot);
		}
	}
	
	public List<Dictionnaire> getMotsPot() {
		return this.motsPot;
	}
	
	public GrillePlaces getGrilleA() { return this.grillea; }
	
	public Dictionnaire getDico() { return this.dico; }

	
	public boolean isDead() {
		//for (Emplacement emp : grillea.getPlaces()) {
		for (Dictionnaire d : motsPot) {
			if (d == null) {
				return true;
			}
		}
		return false;
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		this.grillea.fixer(m, soluce);
		GrillePotentiel res = new GrillePotentiel(grillea, dico) ;
		return res;
	}
}