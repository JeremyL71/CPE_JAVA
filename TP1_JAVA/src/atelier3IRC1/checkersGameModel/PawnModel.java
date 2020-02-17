package atelier3IRC1.checkersGameModel;


import java.util.List;

import atelier3IRC1.checkersGameNutsAndBolts.PieceSquareColor;


public class PawnModel implements PieceModel {

	private Coord coord;
	private PieceSquareColor pieceColor;
	
	private int direction;
	
	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		this.coord = coord;
		this.pieceColor = pieceColor;
		this.direction = PieceSquareColor.BLACK.equals(this.getPieceColor()) ? -1 : 1;
	}

	@Override
	public Coord getCoord() {
		return coord;
	}

	@Override
	public void move(Coord coord) {
		this.coord = coord; 
	}

	@Override
	public PieceSquareColor getPieceColor() {
		return pieceColor;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getCoord().getColonne();
		int ligDistance = targetCoord.getLigne() - this.getCoord().getLigne();
		int deltaLig = (int) Math.signum(ligDistance);
		
		// Cas d'un déplacement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){
			
			// sans prise
			if (!isPieceToTake) {
				if (deltaLig == this.direction && Math.abs(colDistance) == 1) {
					ret = true;
				}
			}
			// avec prise
			else {
				if (Math.abs(colDistance) == 2) {
					ret = true;
				}
			}
		}
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

