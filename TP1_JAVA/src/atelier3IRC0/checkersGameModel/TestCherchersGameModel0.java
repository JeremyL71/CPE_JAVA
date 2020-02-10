package atelier3IRC0.checkersGameModel;

import atelier3IRC0.checkersGameNutsAndBolts.PieceSquareColor;

/**
 * @author francoiseperrin
 *
 * Programme de test des classes du model
 */
public class TestCherchersGameModel0 {


	public static void main(String[] args) {

		//////////////////////////////////
		// Test classe Coord
		//////////////////////////////////

		System.out.println("Test classe Coord");
		Coord c1 = new Coord('a', 7);
		Coord c2 = new Coord('b', 3);
		System.out.println("MAX = " + Coord.MAX);
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c1.equals(c2) ? "+ c1.equals(c2));	// false
		System.out.println("c1.equals(new Coord('a', 7)) ? "+ c1.equals(new Coord('a', 7)));	// il ne s'agit pas d'une copie
		System.out.println("coord valides ('a',7) ? "+ Coord.coordonnees_valides(c1));		//true
		System.out.println("coord valides ('w',9) ? "+ Coord.coordonnees_valides(new Coord('w',9)));	//false
		System.out.println("coord valides ('b',11) ? "+ Coord.coordonnees_valides(new Coord('b',11) ));	//false
//		System.out.println("c1.compareTo(c2) ? "+ c1.compareTo(c2) );	// c1 < c2
//		System.out.println("c1.compareTo(new Coord('a', 7)) ? "+ c1.compareTo(new Coord('a', 7)) );	// coords �gales
//
//
//		//////////////////////////////////
//		// Test classe PawnModel
//		//////////////////////////////////
//
//		System.out.println("\nTest classe PawnModel");
//		PieceModel pieceModel1 = new PawnModel(new Coord('a', 7), PieceSquareColor.BLACK);
//		PieceModel pieceModel2 = new PawnModel(new Coord('b', 4), PieceSquareColor.WHITE);
//		PieceModel pieceModel3 = new PawnModel(new Coord('e', 7), PieceSquareColor.BLACK);
//		System.out.println("pieceModel1 = " + pieceModel1);
//		pieceModel1.move(new Coord('b', 6));
//		System.out.println("pieceModel1 = " + pieceModel1);
//		System.out.println("isMoveOk ('b',4) --> ('c',5) = " + pieceModel2.isMoveOk(new Coord('c',5),false)); // true
//		System.out.println("isMoveOk ('e',7) --> ('d',6) = " + pieceModel3.isMoveOk(new Coord('d',6),false)); // true
//		pieceModel2.move(new Coord('c', 5));
//		pieceModel3.move(new Coord('d', 6));
//		System.out.println("isMoveOk ('c',5) --> ('e',7) = " + pieceModel2.isMoveOk(new Coord('e',7),true)); // true avec prise
//		System.out.println("isMoveOk ('c',5) --> ('d',6) = " + pieceModel2.isMoveOk(new Coord('d',6),true)); // false occup�
//		System.out.println("isMoveOk ('c',5) --> ('b',6) = " + pieceModel2.isMoveOk(new Coord('b',6),true)); // false pas de 1 et pas obstacle
//		System.out.println("isMoveOk ('d',4) --> ('f',6) = " + pieceModel2.isMoveOk(new Coord('f',6),false)); // false pas de 2 et pas obstacle
//
//
//		//////////////////////////////////
//		// Test classe ModelImplementor
//		//////////////////////////////////
//
//		System.out.println("\nTest classe ModelImplementor");
//		ModelImplementor modelImpl = new ModelImplementor();
//		System.out.println("findPieceModel ('b',4) = " + modelImpl.findPiece(new Coord('b',4)));	// OK
//		System.out.println("findPieceModel ('b',6) = " + modelImpl.findPiece(new Coord('b',6)));	// KO
//		System.out.println("getPieceColor('b',4) = " + modelImpl.getPieceColor(new Coord('b',4)));	// WHITE
//		System.out.println("getPieceColor('b',6) = " + modelImpl.getPieceColor(new Coord('b',6)));	// KO
//		System.out.println("isPiecehere('b',4) = " + modelImpl.isPiecehere(new Coord('b',4)));	// true 
//		System.out.println("isPiecehere('b',6) = " + modelImpl.isPiecehere(new Coord('b',6)));	// false 
//		System.out.println("isMovePieceOk ('b',4) -> ('c',5) = " + 
//				modelImpl.isMovePieceOk(new Coord('b',4), new Coord('c',5),false));	// true
//		System.out.println("movePiece ('b',4) -> ('c',5) = " + 
//				modelImpl.movePiece(new Coord('b',4), new Coord('c',5)));	// move OK
//
//
//		//////////////////////////////////
//		// Test classe Model
//		//////////////////////////////////
//
//		System.out.println("\nTest classe Model");
//		Model model = new Model();
//		System.out.println("isPieceMoveable ('b',4) = " + model.isPieceMoveable(new Coord('b',4)));	// true
//		System.out.println("isPieceMoveable ('c',7) = " + model.isPieceMoveable(new Coord('c',7)));	// false, tour des blancs
//
//		System.out.println("isMovePieceOk ('b',4) -> ('c',5) = " + 
//				model.isMovePieceOk(new Coord('b',4), new Coord('c',5)));	// true
//		System.out.println("movePiece ('b',4) -> ('c',5) = move OK" );
//		model.movePiece(new Coord('b',4), new Coord('c',5));	// move OK
//
//		System.out.println("\n");
//		System.out.println("isPieceMoveable ('c',7) = " + model.isPieceMoveable(new Coord('c',7)));	// true
//		System.out.println("isMovePieceOk ('c',7) -> ('c',6) = " + 
//				model.isMovePieceOk(new Coord('c',7), new Coord('c',6)));	// false
//		System.out.println("movePiece ('c',7) -> ('c',6) = move KO pas diagonale" );	
//		model.movePiece(new Coord('c',7), new Coord('c',6));	// move KO

	}


}
