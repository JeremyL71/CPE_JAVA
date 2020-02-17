package atelier3IRC1.checkersGameModel;


import atelier3IRC1.checkersGameNutsAndBolts.PieceSquareColor;

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
 * 
 * Ne sont pas gérés les prises, les rafles, les dames, 
 * ni le fait que lorsqu'une prise est possible
 * une autre pièce ne doit pas être jouée
 * 
 */
public class Model  {

	private PieceSquareColor currentColor;	// couleur du joueur courant

	private ModelImplementor implementor = null;
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
		PieceSquareColor pieceColor = this.implementor.getPieceColor(coord);

		if (pieceColor != null && pieceColor.equals(currentColor)) {
			bool  = true;
		}
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
		this.isPieceToMove = false;

		// s'il existe une pièce à  déplacer, 
		// et que case d'arrivée est inoccupée et dans les limites du damier
		if(this.implementor.isPiecehere(initCoord) &&
				Coord.coordonnees_valides(targetCoord) &&
				!this.implementor.isPiecehere(targetCoord)) {

			// Vérif si déplacement en diagonale est possible avec le bon pas
			// Pour l'instant, on ne teste que le déplacement sans prise
			isMoveOk = this.implementor.isMovePieceOk(initCoord, targetCoord, false ) ;

			this.isPieceToMove = isMoveOk;
		}
		return isMoveOk;
	}


	/**
	 * @param initCoord
	 * @param targetCoord
	 * @return null car POUR L'INSTANT, test sans prise 
	 */
	public Coord movePiece(Coord initCoord, Coord targetCoord) {

		Coord tookPieceCoord = null;

		// si le déplacement est légal
		if (this.isPieceToMove) {

			// déplacement effectif de la pièce
			this.implementor.movePiece(initCoord, targetCoord);
			
			// changement joueur courant 
			this.currentColor = (PieceSquareColor.WHITE).equals(this.currentColor) ?
					PieceSquareColor.BLACK : PieceSquareColor.WHITE;
		}
		System.out.println(this);

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