package app.models.pieces;

import app.controller.ChessBoard;
import app.controller.Spot;

public class Rook extends Piece {

	public Rook(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		return this.canMoveStraight(board, start, end);
	}

}
