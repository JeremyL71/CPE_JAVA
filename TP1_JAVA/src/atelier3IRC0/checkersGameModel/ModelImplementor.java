package atelier3IRC0.checkersGameModel;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 * 
 * Cete classe fabrique et stocke toutes les PieceModel du Model dans une collection 
 * elle est donc responsable de rechercher et mettre à jour les PieceModel (leur position)
 * 
 * En revanche, elle n'est pas responsable des algorithme métiers liés au déplacement des pièces
 * (responsabilité de la classe Model)
 */
public class ModelImplementor {

	// la collection de pièces en jeu - mélange noires et blanches
	private Collection<PieceModel> pieces = null;	

	public ModelImplementor() {
		super();
		pieces = new LinkedList<PieceModel>();
	
		// Création des pièces blanches et ajout dans la collection de pièces
		for ( Coord coord : ModelConfig.WHITE_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.WHITE));
		}
		
		// Création des pièces noires et ajout dans la collection de pièces
		for ( Coord coord : ModelConfig.BLACK_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
		}

	}

	public PieceSquareColor getPieceColor(Coord coord) {
		PieceSquareColor color = null;
		
		// ToDo
		
		return color;
	}

	public boolean isPiecehere(Coord coord) {
		boolean isPiecehere = false;
		
		// ToDo
		
		return isPiecehere;
	}

	public boolean isMovePieceOk(Coord initCoord, Coord targetCoord, boolean isPieceToTake) {

		boolean isMovePieceOk = false;
		
		// ToDo
		
		return isMovePieceOk;
	}


	public boolean movePiece(Coord initCoord, Coord targetCoord) {
		
		boolean isMovePieceDone = false;
		
		// ToDo
		
		return isMovePieceDone;
	}

	/**
	 * @param coord
	 * @return la pièce qui se trouve aux coordonnées indiquées
	 */
	PieceModel findPiece(Coord coord) {		// visibilité Package pour être testé dans TestCherchersGameModel
		//	private PieceModel findPiece(Coord coord) {		// A décommenter après les tests
		
		PieceModel findPiece = null;

		
		// ToDo
		
		return findPiece;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * La méthode toStrong() retourne une représentation 
	 * de la liste de pièces sous forme d'un tableau 2D
	 * 
	 */
	public String toString() {

		String st = "";
		String[][] damier = new String[ModelConfig.LENGTH][ModelConfig.LENGTH];

//		// création d'un tableau 2D avec les noms des pièces à partir de la liste de pièces
//		for(PieceModel piece : this.pieces) {
//
//			PieceSquareColor color = piece.getPieceColor();
//			String stColor = (PieceSquareColor.WHITE.equals(color) ? "--B--" : "--N--" );
//
//			int col = piece.getCoord().getColonne()-'a';
//			int lig = piece.getCoord().getLigne() -1;
//			damier[lig][col ] = stColor ;
//		}

		// Affichage du tableau formatté
		st = "     a      b      c      d      e      f      g      h      i      j\n";
		for ( int lig = 9; lig >=0 ; lig--) {
			st += (lig+1) + "  ";
			for ( int col = 0; col <= 9; col++) {					 
				String stColor = damier[lig][col];				
				if (stColor != null) {						
					st += stColor + "  ";	
				} 
				else {
					st += "-----  ";
				}
			}
			st +="\n";
		}
		return "Damier du model \n" + st;	
	}


}
