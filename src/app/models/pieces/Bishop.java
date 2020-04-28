package app.models.pieces;

import app.controller.ChessBoard;
import app.controller.Spot;

public class Bishop extends Piece {

	public Bishop(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		return this.canMoveDigonal(board, start, end);
	}

}
