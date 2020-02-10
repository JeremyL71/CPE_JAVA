package atelier3IRC0.checkersGameModel;

import java.util.Collection;

import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 *
 * Cette classe gère les aspects métiers du jeu de dame
 * indépendement de toute vue
 * 
 * Elle délègue à son objet ModelImplementor 
 * le stockage des PieceModel dans une collection
 * 
 * Les pièces sont capables de se déplacer d'une case en diagonale 
 * si la case de destination est vide
 * ou de 2 cases en diagonale s'il existe une pièce
 * du jeu opposé à  prendre sur le trajet
 * 
 * 
 */
public class Model  {

	private ModelImplementor implementor;	// objet qui gère la collection de PiecedModel
	private PieceSquareColor currentColor;	// couleur du joueur courant
	private boolean isPieceToMove;			// pièce à  déplacer

	public Model() {
		super();
		this.implementor = new ModelImplementor();
		this.currentColor = ModelConfig.BEGIN_COLOR;
		System.out.println(this);
	}

	/**
	 * @param coord
	 * @return true si la PieceModel qui se trouve aux coordonnées indiquées 
	 * est de la couleur du joueur courant 
	 */
	public boolean isPieceMoveable(Coord coord) {
		boolean bool  = false;
		
		// ToDo
		
		return bool ;
	}

	/**
	 * @param initCoord
	 * @param targetCoord
	 * @return true si le déplacement est légal
	 * (s'effectue en diagonale, POUR L'INSTANT sans prise)
	 * La PieceModel qui se trouve aux coordonnées passées en paramètre 
	 * est capable de répondre à  cette question (par l'intermédiare du ModelImplementor)
	 * 
	 */
	public boolean isMovePieceOk(Coord initCoord, Coord targetCoord) {

		boolean isMoveOk = false;
		
		// ToDo
		
		return isMoveOk;
	}


	/**
	 * @param initCoord
	 * @param targetCoord
	 * @return null car POUR L'INSTANT, test sans prise 
	 */
	public Coord movePiece(Coord initCoord, Coord targetCoord) {

		Coord tookPieceCoord = null;

		// ToDo
		
		return  tookPieceCoord;
	}


	public int getLength() {
		return ModelConfig.LENGTH;
	}

	@Override
	public String toString() {
		return implementor.toString();
	}


}