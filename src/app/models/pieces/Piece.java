package app.models.pieces;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import app.controller.ChessBoard;
import app.controller.Spot;

public abstract class Piece {
	protected boolean killed = false;
	protected boolean white = false;
	protected Image image;

	public Piece(boolean white) {
		this.white = white;
		setImage();
	}

	public Image getImage() {
		return this.image;
	}

	public boolean isWhite() {
		return this.white == true;
	}

	public boolean isKilled() {
		return this.killed == true;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}

	public abstract boolean canMove(ChessBoard board, Spot start, Spot end);

	private void setImage() {
		String imgName;
		if (this.isWhite())
			imgName = "W";
		else
			imgName = "B";

		imgName += this.getClass().getSimpleName();
		File imgFile = new File("./img/" + imgName + ".png");
		try {
			this.image = ImageIO.read(imgFile).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean canMoveStraight(ChessBoard board, Spot start, Spot end) {
		if (start.getX() == end.getX()) {
			if (start.getY() < end.getY()) {
				for (int y = start.getY() + 1; y < end.getY(); y++) {
					if (board.getBoxes()[end.getX()][y].getPiece() != null)
						return false;
				}
			} else {
				for (int y = end.getY() + 1; y < start.getY(); y++) {
					if (board.getBoxes()[end.getX()][y].getPiece() != null)
						return false;
				}
			}
			// Eat enemy
			if (end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite())
				return false;
			return true;
		}
		if (start.getY() == end.getY()) {
			if (start.getX() > end.getX()) {
				for (int x = end.getX() + 1; x < start.getX(); x++) {
					if (board.getBoxes()[x][end.getY()].getPiece() != null)
						return false;
				}
			} else {
				for (int x = start.getX() + 1; x < end.getX(); x++) {
					if (board.getBoxes()[x][end.getY()].getPiece() != null)
						return false;
				}
			}
			// Eat enemy
			if (end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite())
				return false;
			return true;

		}
		return false;
	}

	public boolean canMoveDigonal(ChessBoard board, Spot start, Spot end) {
		if (Math.abs(start.getX() - end.getX()) != Math.abs(start.getY() - end.getY())) {
			return false;
		}
		// Go Up
		if (start.getX() > end.getX()) {
			// Go Left
			if (start.getY() > end.getY()) {
				for (int i = 1; i < start.getX() - end.getX(); i++) {
					if (board.getBoxes()[end.getX() + i][end.getY() + i].getPiece() != null)
						return false;
				}
				// Check eat
				if (end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite())
					return false;
				return true;
			}
			// Go Right
			else if (start.getY() < end.getY()) {
				for (int i = 1; i < start.getX() - end.getX(); i++) {
					if (board.getBoxes()[end.getX() + i][end.getY() - i].getPiece() != null)
						return false;
				}
				// Check eat
				if (end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite())
					return false;
				return true;
			} else
				return false;
		}
		// Go Down
		else if (start.getX() < end.getX()) {
			// Go Right
			if (start.getY() < end.getY()) {
				for (int i = 1; i < end.getX() - start.getX(); i++) {
					if (board.getBoxes()[start.getX() + i][start.getY() + i].getPiece() != null)
						return false;
				}
				// Check eat
				if (end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite())
					return false;
				return true;
			}
			// Go Left
			else if (start.getY() > end.getY()) {
				for (int i = 1; i < end.getX() - start.getX(); i++) {
					if (board.getBoxes()[start.getX() + i][start.getY() - i].getPiece() != null)
						return false;
				}
				// Check eat
				if (end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite())
					return false;
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	public ArrayList<Spot> findSpot(ChessBoard board, Spot current){
		ArrayList<Spot> avaiable = new ArrayList<Spot>();
		
		for(int i = 0; i < board.getBoxes().length; i++) {
			for(int j = 0; j < board.getBoxes().length; j++) {
				if(this.canMove(board, current, board.getBoxes()[i][j])) {
					avaiable.add(board.getBoxes()[i][j]);
				}
			}
		}
		
		return avaiable;
	}
}
