package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre{
	private List<Character> ens = new ArrayList<>();
	
	public EnsembleLettre() {}
	public EnsembleLettre(List<Character> ens) {
		super();
		this.ens = ens;
	}
	
	public void add(Character c) { //ajouter une lettre (sans doublon)
		if (! ens.contains(c)){
			ens.add(c);
		}
	}

	public EnsembleLettre intersection(EnsembleLettre e2) {
		ArrayList<Character> al = new ArrayList<>(ens);
		al.retainAll(e2.ens);
		return new EnsembleLettre(al);
	}
	
	public int size() {
		return ens.size();
	}

	public boolean contains(Character c) {
		return ens.contains(c);
	}
	
	public Character get(int i) {
		return ens.get(i);
	} 
	
	
}