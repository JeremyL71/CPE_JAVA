package atelier3IRC0.checkersGameModel;

import java.util.Collection;

import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 *
 * Cette classe g�re les aspects m�tiers du jeu de dame
 * ind�pendement de toute vue
 * 
 * Elle d�l�gue � son objet ModelImplementor 
 * le stockage des PieceModel dans une collection
 * 
 * Les pi�ces sont capables de se d�placer d'une case en diagonale 
 * si la case de destination est vide
 * ou de 2 cases en diagonale s'il existe une pi�ce
 * du jeu oppos� � prendre sur le trajet
 * 
 * 
 */
public class Model  {

	private ModelImplementor implementor;	// objet qui g�re la collection de PiecedModel
	private PieceSquareColor currentColor;	// couleur du joueur courant
	private boolean isPieceToMove;			// pi�ce � d�placer

	public Model() {
		super();
		this.implementor = new ModelImplementor();
		this.currentColor = ModelConfig.BEGIN_COLOR;
		System.out.println(this);
	}

	/**
	 * @param coord
	 * @return true si la PieceModel qui se trouve aux coordonn�es indiqu�es 
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
	 * @return true si le d�placement est l�gal
	 * (s'effectue en diagonale, POUR L'INSTANT sans prise)
	 * La PieceModel qui se trouve aux coordonn�es pass�es en param�tre 
	 * est capable de r�pondre � cette question (par l'interm�diare du ModelImplementor)
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