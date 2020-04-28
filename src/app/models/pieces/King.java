package app.models.pieces;

import app.controller.ChessBoard;
import app.controller.Spot;

public class King extends Piece {

	public King(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		
		return false;
	}
}
