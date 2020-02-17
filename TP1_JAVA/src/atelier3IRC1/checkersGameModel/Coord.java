package atelier3IRC1.checkersGameModel;

/**
 * @author francoiseperrin
 *
 * Coordonnées des PieceModel
 */
public class Coord implements Comparable<Coord>{

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colonne;
		result = prime * result + ligne;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (colonne != other.colonne)
			return false;
		if (ligne != other.ligne)
			return false;
		return true;
	}

	/**
	 * @param coord
	 * @return true si 'a' <= col < 'a'+MAX et 1 < lig <= MAX
	 */
	public static boolean coordonnees_valides(Coord coord){

		return ( (coord.getColonne()< 'a' + MAX) && 
				(coord.getColonne()>= 'a') && 
				(coord.getLigne()<= MAX) && 
				(coord.getLigne()> 0) );
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * Permet de trier selon l'indice dans la matrice (entre 1 et MAX)
	 */
	@Override
	public int compareTo(Coord o) {
		int thisValue = (MAX-this.ligne)*MAX + (this.colonne-'a'+1);
		int oValue = (MAX-o.ligne)*MAX + (o.colonne-'a'+1);
		return thisValue - oValue ;
	}

}
