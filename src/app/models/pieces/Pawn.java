package app.models.pieces;

import app.controller.ChessBoard;
import app.controller.Spot;

public class Pawn extends Piece {

	public Pawn(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		if (this.white) {
			// One step
			if (start.getX() - end.getX() == 1 && start.getY() == end.getY() && end.getPiece() == null)
				return true;
			// Tow step
			if (start.getX() == 6 && end.getX() == 4 && start.getY() == end.getY() && end.getPiece() == null
					&& board.getBoxes()[5][start.getY()].getPiece() == null)
				return true;
			// Eat black
			if (start.getX() - end.getX() == 1 && Math.abs(start.getY() - end.getY()) == 1 && end.getPiece() != null
					&& !end.getPiece().isWhite())
				return true;
		}
		if (!this.white) {
			// One step
			if (start.getX() - end.getX() == -1 && start.getY() == end.getY() && end.getPiece() == null)
				return true;
			// Tow step
			if (start.getX() == 1 && end.getX() == 3 && start.getY() == end.getY() && end.getPiece() == null
					&& board.getBoxes()[2][start.getY()].getPiece() == null)
				return true;
			// Eat black
			if (start.getX() - end.getX() == -1 && Math.abs(start.getY() - end.getY()) == 1 && end.getPiece() != null
					&& end.getPiece().isWhite())
				return true;
		}

		return false;
	}

}
