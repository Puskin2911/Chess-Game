package app.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import app.controller.ChessBoard;
import app.controller.Spot;

public class ChessPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ChessBoard board;
	private final int cell_size = 70;
	private boolean clicked;
	private Spot waiting;

	public ChessPanel() {
		this.setLayout(new GridLayout(8, 8));
		this.setSize(8 * cell_size, 8 * cell_size);

		board = new ChessBoard();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.add(board.getBoxes()[i][j]);
				board.getBoxes()[i][j].addActionListener(this);
			}
		}

	}
	
	private void drawBoard() {
		for(int i = 0; i < board.getBoxes().length; i++) {
			for(int j = 0; j < board.getBoxes().length; j++) {
				if ((i + j) % 2 == 0) {
					board.getBoxes()[i][j].setBackground(Color.WHITE);
				} else {
					board.getBoxes()[i][j].setBackground(Color.GRAY);
				}
				if (board.getBoxes()[i][j].getPiece() != null) {
					board.getBoxes()[i][j].setIcon(new ImageIcon(board.getBoxes()[i][j].getPiece().getImage()));
				} else {
					board.getBoxes()[i][j].setIcon(null);
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Spot current = (Spot) e.getSource();
		if (clicked) {
			if (waiting.equals(current)) {
				clicked = false;
				drawBoard();
				return;
			}
			if (waiting.getPiece().canMove(board, waiting, current)) {
				board.getBoxes()[current.getX()][current.getY()].setPiece(waiting.getPiece());
				board.getBoxes()[waiting.getX()][waiting.getY()].setPiece(null);
			}

			drawBoard();
			clicked = false;
		} else {
			if (current.getPiece() != null) {
				waiting = current;
				clicked = true;
				current.setBackground(Color.GREEN);
				ArrayList<Spot> avaiable = current.getPiece().findSpot(this.board, current);
				for (Spot spot : avaiable) {
					if(spot.getPiece() == null) {
						spot.setBackground(Color.YELLOW);
					}
					else {
						spot.setBackground(Color.RED);
					}
				}
			}
		}
	}
}
