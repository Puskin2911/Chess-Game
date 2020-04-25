package app.models;

import app.ChessBoard;
import app.Spot;

public class Rook extends Piece {

	public Rook(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		return false;
	}

}
