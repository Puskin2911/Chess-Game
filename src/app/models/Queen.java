package app.models;

import app.ChessBoard;
import app.Spot;

public class Queen extends Piece {

	public Queen(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
