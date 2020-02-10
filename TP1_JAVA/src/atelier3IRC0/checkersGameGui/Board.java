package atelier3IRC0.checkersGameGui;



import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import atelier3IRC0.checkersGameController.Controller;
import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoiseperrin
 * <p>
 * Cette classe représente le damier de la vue
 * <p>
 * Elle tire les valeurs d'affichage d'une fabrique de constante (GuiConfig) :
 * 		public final static int size = 10;
 * 		public final static double height = 600.0;
 * 
 */
class Board extends GridPane {

	private final Controller controller;
	private Canvas selectedPieceGui;					// la pièce à  déplacer
	private int selectedPieceIndex;						// index de la pièce avant déplacement 

	private int nbCol, nbLig;                			// le nb de ligne et de colonne du damier
	private double height;								// taille du damier en pixel

	private EventHandler<MouseEvent> squareListener;   	// l'écouteur d'évènements souris sur les carrés du damier
	private EventHandler<MouseEvent> pieceListener;   	// l'écouteur d'évènements souris sur les pièces

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
				// sélection de la couleur de la case
				if ((col % 2 == 0 && ligne % 2 == 0) || (col % 2 != 0 && ligne % 2 != 0)) {
					squareColor = PieceSquareColor.WHITE;
				} else {
					squareColor = PieceSquareColor.BLACK;
				}

				// création d'un Pane
				square = GuiFactory.createSquare(squareColor);

				// ajout d'un écouteur sur le carré
				square.setOnMouseClicked(squareListener);

				// gestion de la taille des Pane
				square.setPrefHeight(this.height/this.nbLig);	// TODO - à  remplacer : bad practice
				square.setPrefWidth(this.height/this.nbCol);	// TODO - à  remplacer : bad practice

				// ajout du carre sur le damier
				this.add(square, col, ligne);

			}
		}
	}


	private void addPiecesOnCheckersBoard () {

		int blackIndex;
		int whiteIndex;

		// ajout pions noirs et blancs sur les cases noires des 4 lignes du haut et du bas
		// Rq : les index des carrés sur le damier varient de 0 à  nbLig*nbLig-1 (=99)
		for (int j = 0; j < this.nbLig * 4; j += 2) {

			// recherche index du carré noir qui contient la pièce noire ou blanche
			if ((j / this.nbLig) % 2 == 0) {
				blackIndex = j + 1;
				whiteIndex = this.nbLig * this.nbLig - j - 2;
			} else {
				blackIndex = j;
				whiteIndex = this.nbLig * this.nbLig - j - 1;
			}

			// ajout effectif du pion noir puis du pion blanc sur les carrés identifiés
			addPieceOnSquare((Pane) this.getChildren().get(blackIndex), PieceSquareColor.BLACK);
			addPieceOnSquare((Pane) this.getChildren().get(whiteIndex), PieceSquareColor.WHITE);
		}

	}


	/**
	 * @param targetSquare
	 * @param pieceColor   Création d'une pièce et ajout dans le bon carré noir
	 */
	private void addPieceOnSquare (Pane targetSquare, PieceSquareColor pieceColor) {

		Canvas pieceGUI;

		// création de la pièce
		pieceGUI = GuiFactory.createPiece(pieceColor);

		// ajout d'un écouteur de souris
		// si la pièce est sélectionnée, elle sera supprimé de son emplacement actuel
		// et repositionnée sur une autre case
		pieceGUI.setOnMouseClicked(this.pieceListener);

		// Ajout de la pièce sur le carré noir
		targetSquare.getChildren().add(pieceGUI);

	}

	/**
	 * @param selectedPiece
	 * @param targetSquare 
	 * Cette méthode est appelée par l'écouteur SquareListener
	 * lorsqu'un carré est cliqué afin d'y déposer une pièce précédemment sélectionnée
	 * on ne vérifie pas les algos potentiels du déplacement de pièces d'un jeu de dame :
	 * pion qui monte, qui peut sauter des pièces de couleurs opposées, qui est obligé de prendre, etc.
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
	 * Cette méthode est appelée par l'écouteur SquareListener
	 * suppression effective d'une pièce
	 */
	private void removePiece(int tookPieceIndex) {

		// clear le carré d'origine de la pièce supprimée
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
	 * Cette méthode est appelée par l'écouteur PieceListener
	 * lorsqu'un clic est effectué sur une pièce avant de la déplacer
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
	 * Objet qui écoute les événements Souris sur les cases du damier
	 * et agit en conséquence 
	 */
	private class SquareListener implements EventHandler<MouseEvent> {

		@Override
		public void handle (MouseEvent mouseEvent) {

			// Déplacement de la pièce sélectionnée
			Board.this.movePiece(
					Board.this.getSelectedPiece(), 
					(Pane) mouseEvent.getSource()
					);
			Board.this.setSelectedPiece(null);
			// On évite que le parent ne récupère l'event
			mouseEvent.consume();
		}

	}

	/**
	 * @author francoise.perrin
	 *
	 * Objet qui écoute les événements Souris sur les cases du damier
	 * et agit en conséquence 
	 */
	private class PieceListener implements EventHandler<MouseEvent> {

		@Override
		public void handle (MouseEvent mouseEvent) {

			Board.this.setSelectedPiece((Canvas) mouseEvent.getSource());

			mouseEvent.consume();
		}

	}



}



