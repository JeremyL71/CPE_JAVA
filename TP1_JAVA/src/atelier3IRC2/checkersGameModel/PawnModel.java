package atelier3IRC2.checkersGameModel;



import java.util.LinkedList;
import java.util.List;

import atelier3IRC2.checkersGameNutsAndBolts.PieceSquareColor;


public class PawnModel extends AbstractPieceModel {

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		this.coord = coord;
		this.pieceColor = pieceColor;
		this.direction = PieceSquareColor.BLACK.equals(this.getPieceColor()) ? -1 : 1;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getCoord().getColonne();
		int ligDistance = targetCoord.getLigne() - this.getCoord().getLigne();
		int deltaLig = (int) Math.signum(ligDistance);

		// Cas d'un d�placement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)) {

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
}
	

