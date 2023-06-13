package pobj.motx.tme3;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme2.GrillePotentiel;

public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes;
	
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		contraintes= new ArrayList<>();
		
		for (int m1=0; m1<grille.getNbHorizontal(); m1++) {                               //parcours d'emplacements horizontaux 
			for (int m2=grille.getNbHorizontal(); m2<grille.getPlaces().size(); m2++) {   //parcours d'emplacements verticaux 
				Emplacement e1 = grille.getPlaces().get(m1);
				Emplacement e2 = grille.getPlaces().get(m2);
				
				for (int c1=0; c1<e1.size(); c1++) {
					for (int c2=0; c2<e2.size(); c2++) {
						
						if (   e1.getCase(c1).equals(e2.getCase(c2))    &&  e1.getCase(c1).isVide()         ) { 
							         //si croisement                        et case sans lettre
							contraintes.add(new CroixContrainte(m1, c1, m2, c2));        //renseigner l’attribut contraintes
						}	
					}	
				}
			}
		}

	}

	public List<IContrainte> getContraintes() { 
		return contraintes; 
	}
	
	/*public GrilleContrainte fixer(int m, String soluce) {
		this.grillea.fixer(m, soluce);
		GrilleContrainte res = new GrilleContrainte(grillea, dico) ;
		return res;
	}
	
	private boolean propage() {
		while(true) {
			for (IContrainte i :  contraintes) {
				i.reduce(gp);
			}
			if (gp.isDead()){return false;}
			
		}
	}*/
	

	
}