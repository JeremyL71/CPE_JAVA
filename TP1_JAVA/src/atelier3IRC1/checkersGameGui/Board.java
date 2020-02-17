package atelier3IRC1.checkersGameGui;


import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import atelier3IRC1.checkersGameController.Controller;
import atelier3IRC1.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoiseperrin
 * <p>
 * Cette classe repr�sente le damier de la vue
 * <p>
 * Elle tire les valeurs d'affichage d'une fabrique de constante (GuiConfig)
 * 		public final static int size = 10;
 * 		public final static double height = 600.0;
 * 
 */
class Board extends GridPane {

	private final Controller controller;
	private Canvas selectedPieceGui;					// la pi�ce � d�placer
	private int selectedPieceIndex;						// index de la pi�ce avant d�placement 

	private int nbCol, nbLig;                			// le nb de ligne et de colonne du damier
	private double height;								// taille du damier en pixel

	private EventHandler<MouseEvent> squareListener;    // l'�couteur d'�v�nements souris sur les carr�s du damier
	private EventHandler<MouseEvent> pieceListener;    	// l'�couteur d'�v�nements souris sur les pi�ces

	public Board (Controller controller) {
		super();

		this.nbCol = nbLig = GuiConfig.SIZE;
		this.height = (double) GuiConfig.HEIGHT;

		this.controller = controller;

		this.squareListener = new SquareListener();
		this.pieceListener = new PieceListener();

		// initialisation du damier
		this.addSquaresOnCheckersBoard();
		this.addPiecesOnCheckersBoard();
	}


	private void addSquaresOnCheckersBoard () {

		Pane square = null;
		PieceSquareColor squareColor = null;

		for (int ligne = 0; ligne < this.nbLig; ligne++) {

			for (int col = 0; col < this.nbCol; col++) {
				// s�lection de la couleur de la case
				if ((col % 2 == 0 && ligne % 2 == 0) || (col % 2 != 0 && ligne % 2 != 0)) {
					squareColor = PieceSquareColor.WHITE;
				} else {
					squareColor = PieceSquareColor.BLACK;
				}

				// cr�ation d'un Pane
				square = SquareGUI.createSquare(squareColor);

				// ajout d'un �couteur sur le carr�
				square.setOnMouseClicked(squareListener);

				// gestion de la taille des Pane
				square.setPrefHeight(this.height/this.nbLig);	// TODO - � remplacer : bad practice
				square.setPrefWidth(this.height/this.nbCol);	// TODO - � remplacer : bad practice

				// ajout du carre sur le damier
				this.add(square, col, ligne);

			}
		}
	}


	private void addPiecesOnCheckersBoard () {

		int blackIndex;
		int whiteIndex;

		// ajout pions noirs et blancs sur les cases noires des 4 lignes du haut et du bas
		// Rq : les index des carr�s sur le damier varient de 0 � nbLig*nbLig-1 (=99)
		for (int j = 0; j < this.nbLig * 4; j += 2) {

			// recherche index du carr� noir qui contient la pi�ce noire ou blanche
			if ((j / this.nbLig) % 2 == 0) {
				blackIndex = j + 1;
				whiteIndex = this.nbLig * this.nbLig - j - 2;
			} else {
				blackIndex = j;
				whiteIndex = this.nbLig * this.nbLig - j - 1;
			}

			// ajout effectif du pion noir puis du pion blanc sur les carr�s identifi�s
			addPieceOnSquare((Pane) this.getChildren().get(blackIndex), PieceSquareColor.BLACK);
			addPieceOnSquare((Pane) this.getChildren().get(whiteIndex), PieceSquareColor.WHITE);
		}

	}


	/**
	 * @param targetSquare
	 * @param pieceColor   Cr�ation d'une pi�ce et ajout dans le bon carr� noir
	 */
	private void addPieceOnSquare (Pane targetSquare, PieceSquareColor pieceColor) {

		Canvas pieceGUI;

		// cr�ation de la pi�ce
		pieceGUI = PieceGUI.createPiece(pieceColor);

		// ajout d'un �couteur de souris
		// si la pi�ce est s�lectionn�e, elle sera supprim� de son emplacement actuel
		// et repositionn�e sur une autre case
		pieceGUI.setOnMouseClicked(this.pieceListener);

		// Ajout de la pi�ce sur le carr� noir
		targetSquare.getChildren().add(pieceGUI);

	}

	/**
	 * @param selectedPiece
	 * @param targetSquare 
	 * Cette m�thode est appel�e par l'�couteur SquareListener
	 * lorsqu'un carr� est cliqu� afin d'y d�poser une pi�ce pr�c�demment s�lectionn�e
	 * on ne v�rifie pas les algos potentiels du d�placement de pi�ces d'un jeu de dame :
	 * pion qui monte, qui peut sauter des pi�ces de couleurs oppos�es, qui est oblig� de prendre, etc.
	 */
	private void movePiece (Canvas selectedPiece, Pane targetSquare) {
		Pane parentSquare;

		if (selectedPiece != null) {
			parentSquare = (Pane)  selectedPiece.getParent();
			targetSquare.getChildren().add(selectedPiece);
			parentSquare.getChildren().removeAll();
		}
	}

	/**
	 * 
	 * @param removeSquare
	 * 
	 * Cette m�thode est appel�e par l'�couteur SquareListener
	 * suppression effective d'une pi�ce
	 */
	private void removePiece(int tookPieceIndex) {

		// clear le carr� d'origine de la pi�ce supprim�e
		Pane tookPieceSquare = (Pane) Board.this.getChildren().get(tookPieceIndex);
		tookPieceSquare.getChildren().clear();
	}


	private Canvas getSelectedPiece() {
		return this.selectedPieceGui;
	}
	private int getSelectedPieceIndex() {
		return this.selectedPieceIndex;
	}
	/**
	 * @param selectedPieceGui 
	 * Cette m�thode est appel�e par l'�couteur PieceListener
	 * lorsqu'un clic est effectu� sur une pi�ce avant de la d�placer
	 */
	private void setSelectedPiece (Canvas selectedPieceGui) {
		this.selectedPieceGui =  selectedPieceGui;
	}
	private void setSelectedPieceIndex (int selectedPieceIndex) {
		this.selectedPieceIndex =  selectedPieceIndex;
	}

	private Controller getController() {
		return controller;
	}


	/**
	 * @author francoise.perrin
	 *
	 * Objet qui �coute les �v�nements Souris sur les cases du damier
	 * et agit en cons�quence 
	 */
	private class SquareListener implements EventHandler<MouseEvent> {

		@Override
		public void handle (MouseEvent mouseEvent) {

			// D�placement de la pi�ce s�lectionn�e
			Board.this.movePiece(
					Board.this.getSelectedPiece(), 
					(Pane) mouseEvent.getSource()
					);
			Board.this.setSelectedPiece(null);
			// On �vite que le parent ne r�cup�re l'event
			mouseEvent.consume();
		}

	}

	/**
	 * @author francoise.perrin
	 *
	 * Objet qui �coute les �v�nements Souris sur les cases du damier
	 * et agit en cons�quence 
	 */
	private class PieceListener implements EventHandler<MouseEvent> {

		@Override
		public void handle (MouseEvent mouseEvent) {

			Board.this.setSelectedPiece((Canvas) mouseEvent.getSource());

			mouseEvent.consume();
		}

	}


}



