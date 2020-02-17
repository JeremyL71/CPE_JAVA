package atelier3IRC0.checkersGameModel;

import java.util.List;

import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel {
	
	private Coord coord;
	private PieceSquareColor pieceColor;
	
	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		this.coord = coord;
		this.pieceColor = pieceColor;
	}

	@Override
	public Coord getCoord() {
		return this.coord;
	}

	@Override
	// Setteur
	public void move(Coord coord) {
		this.coord = coord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		return pieceColor;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake) {
		int forward;
		//Déplacement avec prise
		if (isPieceToTake == false)
			forward = 1;
		else
			forward = 2 ;
		pieceColor = getPieceColor();
		if (pieceColor == PieceSquareColor.WHITE)
		{
			// POUR LES BLANCS
			if(targetCoord.getLigne() == this.coord.getLigne()+forward && (targetCoord.getColonne() == ( this.coord.getColonne()+forward) || targetCoord.getColonne() == ( this.coord.getColonne()-forward)))
			{
				return true;
			}
		}
		else
		{
			// POUR LES NOIRS
			if(targetCoord.getLigne() == this.coord.getLigne()-forward && (targetCoord.getColonne() == ( this.coord.getColonne()+forward) || targetCoord.getColonne() == ( this.coord.getColonne()-forward)))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {
		
		List<Coord> coordsOnItinerary = null;
		
		// ToDo
		
		return coordsOnItinerary;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " ["+pieceColor.toString().charAt(0) + coord + "]";
	}

	
}

