package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IVariable;

public class MotX implements ICSP{
	public MotX(GrilleContrainte gc) {}
	
	public List<IVariable> getVars(){}
	public boolean isConsistent() {return true;}
	public ICSP assign(IVariable vi, String val) {}
}