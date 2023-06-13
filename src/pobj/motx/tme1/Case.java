package pobj.motx.tme1;

public class Case{
	private int x;
	private int y;
	private char val;
	public Case(int lig, int col, char c) {
		this.x= lig;
		this.y = col;
		this.val =c;
	}
	
	public int getLig() {
		return x;
	}
	
	public int getCol() {
		return y ;
	}
	
	public char getChar() {
		return val;
	}
	
	public void setChar(char c) {
		this.val=c;
	}
	
	public boolean isVide() {
		return val==' ';
	}
	 
	public boolean isPleine() {
		return val=='*'; //case avec lettre n'étant ni vide ni pleine
	}
	
	public boolean equals(Object other) {
		if (other==this) return true;
		if (other==null) return false;
		if ( !(other instanceof Case) ) return false;
		
		Case c = (Case)other;
		return x==c.getLig() && y==c.getCol() && val==c.getChar();
		
	}
	
	
}
