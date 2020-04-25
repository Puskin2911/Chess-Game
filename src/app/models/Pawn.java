package app.models;

import app.ChessBoard;
import app.Spot;

public class Pawn extends Piece {

	public Pawn(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		if(!this.isValidMove(board, start, end)) return false;
		if(Math.abs(start.getX() - end.getX()) > 2) return false;
		if(!(start.getPiece() instanceof Pawn)) return false;
		
		// 2 steps
		if(Math.abs(start.getX() - end.getX()) == 2) {
			// White
			if(this.white) {
				if(start.getX() == 6 && start.getY() == end.getY()) {
					if(end.getPiece() == null && board.getBoxes()[5][start.getY()] == null) return true;
					else return false;
				}
				return false;
			}
			// Black
			else {
				if(start.getX() == 1 && start.getY() == end.getY()) {
					if(end.getPiece() == null && board.getBoxes()[2][start.getY()] == null) return true;
					else return false;
				}
				return false;
			}
		}
		// 1 step
		if(Math.abs(start.getX() - end.getX()) == 1) {
			return true;
		}
		
		
		return false;
	}

}
