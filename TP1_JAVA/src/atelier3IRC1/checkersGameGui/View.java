package atelier3IRC1.checkersGameGui;



import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import atelier3IRC1.checkersGameController.Controller;

/**
 * @author francoise.perrin
 * 
 * Cette classe est la fenàªtre du jeu de dames
 * Elle délègue a un objet la gestion de l'affichage du damier
 * 
 */
public class View extends GridPane {

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
		
		// ajout du fond d'écran à  la vue
		this.add(checkersBoard, 0, 1);
	}

}


