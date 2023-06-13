package pobj.motx.tme1;
import java.util.ArrayList;
import java.util.List;

public class Emplacement{
	private List<Case> cases;
	
	public Emplacement() {
		cases = new ArrayList<>();
	}
	
	public void add(Case e) {
		cases.add(e);
		
	}
	public int size(){
		return cases.size();
	}
	public Case getCase(int i) {
		return cases.get(i);
	}
	
	
}
