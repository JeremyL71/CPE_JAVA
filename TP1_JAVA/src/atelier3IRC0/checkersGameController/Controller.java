package atelier3IRC0.checkersGameController;

import atelier3IRC0.checkersGameModel.Coord;
import atelier3IRC0.checkersGameModel.Model;

/**
 * @author francoiseperrin
 *
 * Méthodes du controller sont invoquées par écouteurs du damier
 * Elles interrogent le Model pour savoir si les déplacements sont légaux
 * Elles permettent également de transformer les coordonnées des pièces :
 * 	- index de 0 à  99 pour la view
 * 	- Coord (col, ligne) pour le model ['a'..'j'][10..1]
 * 
 */
public class Controller {

	private Model model;

	private int  length;

	public Controller(Model model) {
		this.model =  model;
		this.length = this.model.getLength();
	}


	/**
	 * @param initSquareIndex
	 * @return true si la PieceGUI sélectionnée correspond à  une PieceModel qui peut àªtre déplacée 
	 * La coordonnée d'origine du déplacement est alors conservée
	 */
	public boolean isPieceMoveable(int initSquareIndex) {
		boolean bool  = false;
		Coord initCoord = this.transformIndexToCoord(initSquareIndex);
		bool = this.model.isPieceMoveable(initCoord);
		return bool;
	}

	/**
	 * @param targetSquareIndex 
	 * @param squareIndex
	 * @return true si la case de destination peut recevoir la pièce sélectionnée 
	 * c'est à  dire si le déplacement est légal du point de vue du model
	 */
	public boolean isMoveTargetOk(int initSquareIndex, int targetSquareIndex) {
		boolean bool  = false;
		Coord initCoord = this.transformIndexToCoord(initSquareIndex);
		Coord targetCoord = this.transformIndexToCoord(targetSquareIndex);
		if (this.model.isPieceMoveable(initCoord)) {
			bool  = this.model.isMovePieceOk(initCoord, targetCoord);
		}
		return bool;
	}


	/**
	 * @param targetSquareIndex 
	 * @param squareIndex
	 * @return index de l'éventuelle pièce à  capturer, -1 sinon
	 * invite le model à  effectuer le déplacement métier
	 */
	public int movePiece(int initSquareIndex, int targetSquareIndex) {
		int tookPieceIndex = -1;
		Coord tookPieceCoord = null ;
		Coord initCoord = this.transformIndexToCoord(initSquareIndex);
		Coord targetCoord = this.transformIndexToCoord(targetSquareIndex);
		tookPieceCoord  = this.model.movePiece(initCoord, targetCoord);

		// les coord de la pièce capturée sont retournée à  la vue pour l'effacer
		if (tookPieceCoord != null) {
			tookPieceIndex = transformCoordToIndex(tookPieceCoord);
		}
		return tookPieceIndex;
	}

	/**
	 * @param squareIndex
	 * @param length
	 * @return les coordonnées métier calculées à  partir de l'index du SquareGUI de la PieceGUI
	 */
	private Coord transformIndexToCoord (int squareIndex) {
		Coord coord = null;
		char col = (char) ((squareIndex)%length + 'a');
		int ligne = length - (squareIndex)/length;
		coord = new Coord(col, ligne);
		return coord;
	}

	private int transformCoordToIndex (Coord coord) {
		int squareIndex = -1;
		if (coord != null) {
			squareIndex = (length - coord.getLigne()) * length + (coord.getColonne()-'a');
		}
		return squareIndex;
	}

}
