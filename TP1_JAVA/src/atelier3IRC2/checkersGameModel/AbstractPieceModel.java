package atelier3IRC2.checkersGameModel;

import atelier3IRC2.checkersGameNutsAndBolts.PieceSquareColor;

import java.util.LinkedList;
import java.util.List;

abstract public class AbstractPieceModel implements PieceModel {
    protected Coord coord;
    protected PieceSquareColor pieceColor;
    protected int direction;

    @Override
    public Coord getCoord() {
        return coord;
    }

    @Override
    public void move(Coord coord) {
        this.coord = coord;
    }

    @Override
    public PieceSquareColor getPieceColor() {
        return pieceColor;
    }

    @Override
    public String toString() {
        return " ["+pieceColor.toString().charAt(0) + coord + "]";
    }

    @Override
    public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

        List<Coord> coordsOnItinery = new LinkedList<Coord>();
        int initCol = this.getCoord().getColonne();
        int initLig = this.getCoord().getLigne();
        int colDistance = targetCoord.getColonne() - this.getCoord().getColonne();
        int ligDistance = targetCoord.getLigne() - this.getCoord().getLigne();
        int deltaLig = (int) Math.signum(ligDistance);
        int deltaCol = (int) Math.signum(colDistance);

        // Verif deplacement en diagonale
        if (Math.abs(colDistance) == Math.abs(ligDistance)){

            // recherche coordonn�es des cases travers�es
            for (int i = 1; i < Math.abs(colDistance); i++) {
                Coord coord = new Coord((char) (initCol + i*deltaCol), initLig + i*deltaLig);
                coordsOnItinery.add(coord);
            }
        }
        return coordsOnItinery;
    }
}
