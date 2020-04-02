package atelier3IRC2.checkersGameModel;


import java.util.List;

import atelier3IRC2.checkersGameNutsAndBolts.PieceSquareColor;

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
 * Ne sont pas g�r�s les rafles, les dames, 
 * ni le fait que lorsqu'une prise est possible
 * une autre pi�ce ne doit pas �tre jou�e
 * 
 */
public class Model  {

	private PieceSquareColor currentColor;	// couleur du joueur courant

	private ModelImplementor implementor = null;
	private boolean isPieceToMove;			// pi�ce � d�placer
	private Coord pieceToTakeCoord;			// Coordonn�es pi�ce � prendre � retourner � la vue

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
		PieceSquareColor pieceColor = this.implementor.getPieceColor(coord);

		if (pieceColor != null && pieceColor.equals(currentColor)) {
			bool  = true;
		}
		return bool ;
	}

	/**
	 * @param initCoord
	 * @param targetCoord
	 * @return true si le d�placement est l�gal
	 * (s'effectue en diagonale, avec ou sans prise)
	 * La PieceModel qui se trouve aux coordonn�es pass�es en param�tre 
	 * est capable de r�pondre � cette question (par l'interm�diare du ModelImplementor)
	 * 
	 */
	public boolean isMovePieceOk(Coord initCoord, Coord targetCoord) {

		boolean isMovePossible = false;
		
		this.isPieceToMove = false;
		this.pieceToTakeCoord = null;

		// s'il existe une pi�ce � d�placer, 
		// et que case d'arriv�e est inoccup�e et dans les limites du damier
		if(this.implementor.isPiecehere(initCoord) &&
				Coord.coordonnees_valides(targetCoord) &&
				!this.implementor.isPiecehere(targetCoord)) {


			// on r�cup�re la liste des coordonn�es des cases sur la trajectoire
			// s'il n'existe qu'1 seule pi�ce � prendre d'une autre couleur sur la trajectoire
			// ou qu'il n'existe pas de pi�ce � prendre, alors, on teste si le d�placement est l�gal
			
			boolean isPieceTotake = false;
			List<Coord> coordsOnItinerary = this.implementor.getCoordsOnItinerary(initCoord, targetCoord);
			
			if (coordsOnItinerary != null) {
				
				// Pas de prise potentielle
				if (coordsOnItinerary.isEmpty() ) {	
					isMovePossible = true;
					isPieceTotake = false; 
				}
				// il existe des cases vides ou occup�es sur la trajectoire
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

			// V�rif si d�placement en diagonale est possible avec le bon pas en fonction
			// de s'il y a 1 pi�ce � prendre ou pas
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
	 * @returnles coordonn�es de la pi�ce qui a �ventuellement �t� prise 
	 */
	public Coord movePiece(Coord initCoord, Coord targetCoord) {

		Coord tookPieceCoord = null;

		// si le d�placement est l�gal
		if (this.isPieceToMove) {

			// d�placement effectif de la pi�ce
			this.implementor.movePiece(initCoord, targetCoord);
			
			// suppression �ventuelle
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