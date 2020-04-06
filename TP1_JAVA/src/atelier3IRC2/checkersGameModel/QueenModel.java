package atelier3IRC2.checkersGameModel;


import java.util.List;

import atelier3IRC2.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoiseperrin
 *
 *le mode de d�placement et de prise de la reine est diff�rent de celui du pion
 */
public class QueenModel extends AbstractPieceModel implements PieceModel {

	public QueenModel(Coord coord, PieceSquareColor pieceColor) {
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
			// Cas d'un d�placement en diagonale
			if (Math.abs(colDistance) == Math.abs(ligDistance)) {
					ret = true;
			}
			return ret;
	}
}

