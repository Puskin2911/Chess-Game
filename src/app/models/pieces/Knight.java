package app.models.pieces;

import app.controller.ChessBoard;
import app.controller.Spot;

public class Knight extends Piece {

	public Knight(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		if(Math.abs(start.getX() - end.getX()) == 2 && Math.abs(start.getY() - end.getY()) == 1) {
			// Check eat
			if(end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) return false;
			return true;
		}
		if(Math.abs(start.getX() - end.getX()) == 1 && Math.abs(start.getY() - end.getY()) == 2) {
			// Check eat
			if(end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) return false;
			return true;
		}
		return false;
	}
	
}
