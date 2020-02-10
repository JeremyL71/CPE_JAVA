package atelier3IRC0.checkersGameModel;

import java.util.List;

import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel {
	
	private Coord coord;
	private PieceSquareColor pieceColor;
	
	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		
		// ToDo 
		
	}

	@Override
	public Coord getCoord() {
		Coord ret = null;

		// ToDo 
		
		return ret;
	}

	@Override
	public void move(Coord coord) {

		// ToDo 
		
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor ret = null;

		// ToDo 
		
		return ret;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake) {
		boolean ret = false;

		// ToDo 
		
		return ret;
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

