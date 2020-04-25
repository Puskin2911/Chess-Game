package app.models;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.ChessBoard;
import app.Spot;
import view.ChessPanel;

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
		if(this.isWhite()) imgName = "W";
		else imgName = "B";
		
		imgName += this.getClass().getSimpleName();
		File imgFile = new File("./img/" + imgName + ".png");
		try {
			ImageIO.setUseCache(false);
			this.image = ImageIO.read(imgFile).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean canMoveStraight(Spot start, Spot end, int steps) {
		if(start.getX() == end.getX() && Math.abs(start.getY() - end.getY()) == steps) {
			return true;
		}
		if(start.getY() == end.getY() && Math.abs(start.getX() - end.getX()) == steps) {
			return true;
		}
		return false;
	}
	
	public boolean isValidMove(ChessBoard board, Spot start, Spot end) {
		if(!start.isValidSpot() || !end.isValidSpot()) {
			return false;
		}
		return true;
	}
}
