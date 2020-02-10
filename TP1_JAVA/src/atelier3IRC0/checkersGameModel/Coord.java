package atelier3IRC0.checkersGameModel;

/**
 * @author francoiseperrin
 *
 * Coordonnées des PieceModel
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
	
	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}
	
	
}
