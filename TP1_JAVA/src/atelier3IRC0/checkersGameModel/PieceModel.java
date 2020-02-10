package atelier3IRC0.checkersGameModel;

import java.util.List;

import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

public interface PieceModel {
	
	
	/**
	 * @return the coord
	 */
	public Coord getCoord() ;
	
	/**
	 * @param coord the coord to set
	 * le déplacement d'une pièce change ses coordonnées
	 */
	public void move(Coord coord);


	/**
	 * @return the pieceColor
	 */
	public PieceSquareColor getPieceColor() ;
	
	
	/**
	 * @param targetCoord
	 * @param isPieceToTake
	 * @return true si le déplacement est légal
	 */
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake);
	
	/**
	 * @param targetCoord
	 * @return liste des coordonnées des cases traversées par itinéraire de déplacement
	 */
	public List<Coord> getCoordsOnItinerary(Coord targetCoord);
	
}

