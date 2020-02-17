package atelier3IRC1.checkersGameGui;

import atelier3IRC1.checkersGameNutsAndBolts.PieceSquareColor;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class PieceGUI {
    public static Canvas createPiece(PieceSquareColor pieceColor) {
        Canvas piece = new Canvas();
        GraphicsContext graphicsContext = piece.getGraphicsContext2D();

        // Gestion de la taille des Canvas 		// TODO - � remplacer atelier 4 : bad practice
        piece.setHeight(GuiConfig.HEIGHT/GuiConfig.SIZE);
        piece.setWidth(GuiConfig.HEIGHT/GuiConfig.SIZE);

        // la couleur est d�finie en dur
        Color color = Color.BLACK;
        if (pieceColor == PieceSquareColor.WHITE) {
            color = Color.WHITE;
        }
        graphicsContext.setFill(color);

        // calcul taille et position pi�ce en fonction du carr�
        double rowWidth = piece.getWidth();
        double rowHeight = piece.getHeight();
        int offset = (int) ((rowWidth + rowHeight) / 6)   ;
        double width = rowWidth - offset;
        double height = rowHeight - offset;
        double upperLeftWidth = offset / 2;
        double upperLeftHeight = offset / 2;
        graphicsContext.fillArc(upperLeftWidth, upperLeftHeight, width, height, 30, 300, ArcType.ROUND);

        return piece;
    }
}
