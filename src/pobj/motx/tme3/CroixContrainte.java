package pobj.motx.tme3;

import pobj.motx.tme2.EnsembleLettre;
import pobj.motx.tme2.GrillePotentiel;

public class CroixContrainte implements IContrainte{
	private int m1; //emplacement
	private int c1; //case
	private int m2;
	private int c2;
	
	public CroixContrainte() {}
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1=m1;
		this.c1=c1;
		this.m2=m2;
		this.c2=c2;
	}
	
	public int reduce(GrillePotentiel grille) {
		EnsembleLettre l1;
		EnsembleLettre l2;
		EnsembleLettre inter;
		l1=grille.getMotsPot().get(m1).calculEL(c1);
		l2=grille.getMotsPot().get(m2).calculEL(c2);
		
		inter = l1.intersection(l2);
		int res=0;
		
		if (l1.size()>inter.size()) {	res+=grille.getMotsPot().get(m1).filtreEL(inter, c1);    }
		
		if (l2.size()>inter.size()) {	res+=grille.getMotsPot().get(m2).filtreEL(inter, c2);    }
		
		return res;
	}
	
	public boolean equals(Object other) {
		if (other==this) return true;
		if (other==null) return false;
		if ( !(other instanceof CroixContrainte) ) return false;
		
		CroixContrainte c = (CroixContrainte)other;
		return m1==c.m1 && c1==c.c1 && m1==c.m2 && c2==c.c2;
		
	}
	
}