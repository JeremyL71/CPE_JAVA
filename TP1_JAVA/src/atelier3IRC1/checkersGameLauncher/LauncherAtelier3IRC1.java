package atelier3IRC1.checkersGameLauncher;


import atelier3IRC1.checkersGameController.Controller;
import atelier3IRC1.checkersGameGui.GuiConfig;
import atelier3IRC1.checkersGameGui.View;
import atelier3IRC1.checkersGameModel.Model;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LauncherAtelier3IRC1 extends Application {

	private Model model;
	private Controller controller;
	private Parent view;
	
	public static void main (String[] args) {

		LauncherAtelier3IRC1.launch();
	}

	@Override
	public void init () throws Exception {
		super.init();
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Objet qui gère les aspects métier du jeu de dame :
		///////////////////////////////////////////////////////////////////////////////////////
		
		this.model = new Model();

		
		///////////////////////////////////////////////////////////////////////////////////////
		// Objet qui contrôle les actions de la vue et les transmet au model
		// il renvoie les réponses du model à  la vue
		///////////////////////////////////////////////////////////////////////////////////////
		
		this.controller = new Controller(model);
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Fenàªtre dans laquelle se dessine le damier
		// et qui propose un menu pour changer la couleur des cases
		// et la forme des pions
		///////////////////////////////////////////////////////////////////////////////////////
				
		this.view = new View(controller);
	}


	@Override
	public void start (Stage primaryStage) {

		primaryStage.setScene(new Scene(this.view, GuiConfig.HEIGHT, GuiConfig.HEIGHT));
		primaryStage.setTitle("Ceci est la fenetre de mon jeu de dames - Version Atelier 1");
		primaryStage.show();
	}

	
}

