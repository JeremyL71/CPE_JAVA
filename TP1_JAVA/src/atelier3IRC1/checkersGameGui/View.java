package atelier3IRC1.checkersGameGui;



import atelier3IRC1.checkersGameModel.ModelConfig;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


import atelier3IRC1.checkersGameController.Controller;

/**
 * @author francoise.perrin
 *
 * Cette classe est la fenàªtre du jeu de dames
 * Elle délègue a un objet la gestion de l'affichage du damier
 *
 */
public class View extends GridPane {
	static final int MAX = ModelConfig.LENGTH;
	public View (Controller controller) {
		super();

		// le damier composé de carrés noirs et blancs
		// sur lesquels sont positionnés des pièces noires ou blanches
		Pane board = new Board(controller);

		// gestion de la taille du damier
		double height = GuiConfig.HEIGHT;			// TODO - à  remplacer (atelier 4) : bad practice
		board.setPrefSize( height, height);			// TODO - à  remplacer (atelier 4) : bad practice

		// création d'un fond d'écran qui contiendra le damier + les axes (atelier 2)
		BorderPane checkersBoard = new BorderPane();

		// ajout du damier au centre du fond d'écran
		checkersBoard.setCenter(board);

		//ajout d'une HBox et VBox
		HBox hbox = generateHBox();
		VBox vbox = generateVBox();

		checkersBoard.setTop(hbox);
		checkersBoard.setLeft(vbox);
		// ajout du fond d'écran à  la vue
		this.add(checkersBoard, 0, 1);
	}

	private VBox generateVBox() {
		VBox vbox = new VBox();
		int i = MAX;

		vbox.setSpacing(40);
		while(i >= 1) {
			vbox.getChildren().add(new Label(String.valueOf(i)));
			i--;
		}
		return vbox;
	}

	private HBox generateHBox() {
		HBox hbox = new HBox();
		//génération de la HBox
		hbox.getChildren().add(new Label(""));
		int i = 0;
		while(i < MAX) {
			hbox.getChildren().add(new Label(String.valueOf((char) ('a' + i))));
			hbox.setSpacing(50);
			i++;
		}

		return hbox;
	}

	/**
	 * génération des Labels
	 * @param board board
	 */
	private void generationLabel(Pane board) {
		// TODO Auto-generated method stub

	}

}


