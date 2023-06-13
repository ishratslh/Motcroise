package pobj.motx.tme1;
public class Grille{
	private Case[][] grille;
	
	public Grille(int hauteur, int largeur) {
		this.grille = new Case[hauteur][largeur];
		for (int l=0; l<hauteur;l++) {
			for (int c=0; c<largeur; c++) {
				grille[l][c]=new Case(l,c, ' ');
			}
		}
	}
	
	
	public Case getCase(int lig, int col) {
		return grille[lig][col];
	}
	
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	public int nbLig() {
		return grille.length;
	}
	
	public int nbCol() {
		return grille[0].length;
	}
	
	public Grille copy() {//redefinir la méthode clone()
		
		Grille res = new Grille(nbLig(), nbCol()) ;
		for (int l=0; l<grille.length;l++) {
			for (int c=0; c<grille[l].length; c++) {
				res.grille[l][c].setChar( getCase(l,c).getChar() );
			}
		}
		return res;
	} //copier l'instance de la grille ET des cases
}
