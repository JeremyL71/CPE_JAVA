package atelier3IRC0.checkersGameModel;

import javax.swing.text.StyledEditorKit;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
			if  (co.getLigne() < 0 || co.getLigne() > MAX){
				coordonnees_valides = false;
			}
		return coordonnees_valides;
	}
	public String compareTo(Object o) {
		/*
			CompareTo est calculé en addition ligne et cologne
		 */
		if (o == null || getClass() != o.getClass()) return "Objects are differents";
		Coord coord = (Coord) o;
		if ((coord.getColonne() + coord.getLigne()) < (this.getLigne() + this.getColonne()))
			return this+">"+coord;
		else if (((coord.getColonne() + coord.getLigne()) == (this.getLigne() + this.getColonne())))
			return this+"="+coord;
		else
			return coord+">"+this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Coord coord = (Coord) o;
		return ((this.getColonne() == coord.getColonne()) && (this.getLigne() == coord.getLigne()));
	}

	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}
	
	
}
