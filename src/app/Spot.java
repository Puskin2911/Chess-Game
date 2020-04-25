package app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import app.models.Piece;

public class Spot extends JButton {
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Piece piece;

	public Spot(int x, int y, Piece piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if ((x + y) % 2 == 0) {
			this.setBackground(Color.WHITE);
		} else {
			this.setBackground(Color.GRAY);
		}
		if (piece != null) {
			this.setIcon(new ImageIcon(piece.getImage()));
		} else {
			this.setIcon(null);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean isValidSpot() {
		return (x >= 0 && x < 8 && y >= 0 && y < 8);
	}

	@Override
	public String toString() {
		return x + " " + y + " " + piece;
	}
}
