package atelier3IRC2.checkersGameModel;


import java.util.List;

import atelier3IRC2.checkersGameNutsAndBolts.PieceSquareColor;

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
 * Ne sont pas gérés les rafles, les dames, 
 * ni le fait que lorsqu'une prise est possible
 * une autre pièce ne doit pas être jouée
 * 
 */
public class Model  {

	private PieceSquareColor currentColor;	// couleur du joueur courant

	private ModelImplementor implementor = null;
	private boolean isPieceToMove;			// pièce à  déplacer
	private Coord pieceToTakeCoord;			// Coordonnées pièce à prendre à retourner à la vue

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
	 * (s'effectue en diagonale, avec ou sans prise)
	 * La PieceModel qui se trouve aux coordonnées passées en paramètre 
	 * est capable de répondre à  cette question (par l'intermédiare du ModelImplementor)
	 * 
	 */
	public boolean isMovePieceOk(Coord initCoord, Coord targetCoord) {

		boolean isMovePossible = false;
		
		this.isPieceToMove = false;
		this.pieceToTakeCoord = null;

		// s'il existe une pièce à  déplacer, 
		// et que case d'arrivée est inoccupée et dans les limites du damier
		if(this.implementor.isPiecehere(initCoord) &&
				Coord.coordonnees_valides(targetCoord) &&
				!this.implementor.isPiecehere(targetCoord)) {


			// on récupère la liste des coordonnées des cases sur la trajectoire
			// s'il n'existe qu'1 seule pièce à prendre d'une autre couleur sur la trajectoire
			// ou qu'il n'existe pas de pièce à prendre, alors, on teste si le déplacement est légal
			
			boolean isPieceTotake = false;
			List<Coord> coordsOnItinerary = this.implementor.getCoordsOnItinerary(initCoord, targetCoord);
			
			if (coordsOnItinerary != null) {
				
				// Pas de prise potentielle
				if (coordsOnItinerary.isEmpty() ) {	
					isMovePossible = true;
					isPieceTotake = false; 
				}
				// il existe des cases vides ou occupées sur la trajectoire
				else { 
					int count = 0;
					Coord potentialPieceToTakeCoord = null;
					for (Coord coordOnItinerary : coordsOnItinerary) {
						if (this.implementor.isPiecehere(coordOnItinerary)) {
							count++;
							potentialPieceToTakeCoord = coordOnItinerary;
						}
					}
					// Toutes les cases sont vides (deplacement pour les dames)
					if (count == 0) {	
						isMovePossible = true; 
					}
					// Prise possible
					if (count == 1 && this.implementor.getPieceColor(initCoord) != 
							this.implementor.getPieceColor(potentialPieceToTakeCoord)) {
						isMovePossible = true;
						isPieceTotake = true;
						this.pieceToTakeCoord = potentialPieceToTakeCoord; 
					}

				}
			}

			// Vérif si déplacement en diagonale est possible avec le bon pas en fonction
			// de s'il y a 1 pièce à prendre ou pas
			if (isMovePossible) { 
				isMovePossible = this.implementor.isMovePieceOk(initCoord, targetCoord, isPieceTotake ) ;
			}
		}
		this.isPieceToMove = isMovePossible;

		return isMovePossible;
	}
	
	/**
	 * @param initCoord
	 * @param targetCoord
	 * @returnles coordonnées de la pièce qui a éventuellement été prise 
	 */
	public Coord movePiece(Coord initCoord, Coord targetCoord) {

		Coord tookPieceCoord = null;

		// si le déplacement est légal
		if (this.isPieceToMove) {

			// déplacement effectif de la pièce
			this.implementor.movePiece(initCoord, targetCoord);
			
			// suppression éventuelle
			if (this.pieceToTakeCoord != null) {
				tookPieceCoord = this.pieceToTakeCoord;
				this.implementor.removePiece(this.pieceToTakeCoord);
			}

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