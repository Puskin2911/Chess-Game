package app.controller;

import javax.swing.JButton;

import app.models.pieces.Piece;

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

	@Override
	public String toString() {
		return x + " " + y + " " + piece;
	}
	
	@Override
	public boolean equals(Object obj) {
		Spot other = (Spot) obj;
		return this.x == other.getX() && this.y == other.getY() && this.piece == other.getPiece();
	}
}
