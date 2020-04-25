package app.models;

import app.ChessBoard;
import app.Spot;

public class King extends Piece {

	public King(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		if(this.isValidMove(board, start, end) == false) return false;
		
		return false;
	}
}
