package app.models.pieces;

import app.controller.ChessBoard;
import app.controller.Spot;

public class Queen extends Piece {

	public Queen(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		if(start.getX() == end.getX() || start.getY() == end.getY())
			return this.canMoveStraight(board, start, end);
		else return this.canMoveDigonal(board, start, end);
	}
	
}
