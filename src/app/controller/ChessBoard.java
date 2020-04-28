package app.controller;

import app.models.pieces.Bishop;
import app.models.pieces.King;
import app.models.pieces.Knight;
import app.models.pieces.Pawn;
import app.models.pieces.Queen;
import app.models.pieces.Rook;

public class ChessBoard{
	private Spot[][] boxes = new Spot[8][8];

	public ChessBoard() {
		
		resetBoard();
	}
		
	public Spot[][] getBoxes(){
		return this.boxes;
	}

	private void resetBoard() {
		// initialize black pieces
		boxes[0][0] = new Spot(0, 0, new Rook(false));
		boxes[0][1] = new Spot(0, 1, new Knight(false));
		boxes[0][2] = new Spot(0, 2, new Bishop(false));
		boxes[0][3] = new Spot(0, 3, new Queen(false));
		boxes[0][4] = new Spot(0, 4, new King(false));
		boxes[0][7] = new Spot(0, 7, new Rook(false));
		boxes[0][6] = new Spot(0, 6, new Knight(false));
		boxes[0][5] = new Spot(0, 5, new Bishop(false));
		for (int i = 0; i < 8; i++) {
			boxes[1][i] = new Spot(1, i, new Pawn(false));
		}
		// initialize white pieces
		boxes[7][0] = new Spot(7, 0, new Rook(true));
		boxes[7][1] = new Spot(7, 1, new Knight(true));
		boxes[7][2] = new Spot(7, 2, new Bishop(true));
		boxes[7][3] = new Spot(7, 3, new King(true));
		boxes[7][4] = new Spot(7, 4, new Queen(true));
		boxes[7][7] = new Spot(7, 7, new Rook(true));
		boxes[7][6] = new Spot(7, 6, new Knight(true));
		boxes[7][5] = new Spot(7, 5, new Bishop(true));
		for (int i = 0; i < 8; i++) {
			boxes[6][i] = new Spot(6, i, new Pawn(true));
		}
		// initialize remaining boxes without any piece
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				boxes[i][j] = new Spot(i, j, null);
			}
		}
	}

}
