package atelier3IRC0.checkersGameModel;

import java.util.Arrays;
import java.util.List;

/**
 * @author francoiseperrin
 *
 * Coordonn�es des PieceModel
 */
public class Coord {

	private char colonne; 
	private int ligne;	
	static final int MAX = ModelConfig.LENGTH;
	
	public Coord(char colonne, int ligne) {
		super();
		this.colonne = colonne;
		this.ligne = ligne;
	}
	
	public char getColonne() {
		return colonne;
	}
	
	public int getLigne() {
		return ligne;
	}

	static public Boolean coordonnees_valides(Coord co)
	{
		boolean coordonnees_valides   = true;
		// Check colonne
			if (co.getColonne() < 'a' || co.getColonne() > 'j') {
				coordonnees_valides = false;
			}
		// Check Ligne
			if  (co.getLigne() < 0 || co.getLigne() > 10){
				coordonnees_valides = false;
			}
		return coordonnees_valides;
	}
	
	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}
	
	
}
