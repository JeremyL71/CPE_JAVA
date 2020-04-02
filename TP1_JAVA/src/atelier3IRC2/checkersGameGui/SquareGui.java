package atelier3IRC2.checkersGameGui;


import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import atelier3IRC2.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoiseperrin
 * 
 * Classe d'affichage des carrés du damier
 * leur couleur est initialisé par les couleurs par défaut du jeu
 *
 */
class SquareGui extends BorderPane  {

	private PieceSquareColor squareColor;    		// le carré est Noir ou Blanc

	public SquareGui (PieceSquareColor squareColor) {
		super();
		this.squareColor = squareColor;

		// la couleur est définie par les valeurs par défaut de configuration
		Color color = PieceSquareColor.BLACK.equals(this.squareColor) ?
				GuiConfig.CASEBLACK : GuiConfig.CASEWHITE;
		this.setBackgroundColor(color);

	}

	private void setBackgroundColor (Color color) {
		this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

}
