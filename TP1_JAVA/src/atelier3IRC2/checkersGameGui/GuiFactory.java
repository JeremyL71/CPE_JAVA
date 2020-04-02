package atelier3IRC2.checkersGameGui;

import atelier3IRC2.checkersGameNutsAndBolts.PieceSquareColor;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class GuiFactory {

	public static Pane createSquare(PieceSquareColor squareColor) {
		return new SquareGui(squareColor);
	}

	public static Canvas createPiece(PieceSquareColor pieceColor) {
		return new PieceGui(pieceColor);
	}
}


