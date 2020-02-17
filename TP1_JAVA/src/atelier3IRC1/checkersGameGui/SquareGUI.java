package atelier3IRC1.checkersGameGui;

import atelier3IRC1.checkersGameNutsAndBolts.PieceSquareColor;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class SquareGUI {
    public static Pane createSquare(PieceSquareColor squareColor) {
        Pane pane = new BorderPane();

        // la couleur est d�finie par les valeurs par d�faut de configuration
        Color color = PieceSquareColor.BLACK.equals(squareColor) ?
                GuiConfig.CASEBLACK : GuiConfig.CASEWHITE;
        pane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));

        return pane;
    }
}
