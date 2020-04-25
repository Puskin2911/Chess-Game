package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import app.ChessBoard;
import app.Spot;
import app.models.Piece;

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

//	@Override
//	protected void paintComponent(Graphics g) {
////		super.paintComponent(g);
//		
//	}

	private void drawBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.add(board.getBoxes()[i][j]);
				board.getBoxes()[i][j].addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Spot current = (Spot) e.getSource();
		if (clicked) {
			if (waiting.getPiece().canMove(board, waiting, current)) {
				board.boxes[current.getX()][current.getY()].setPiece(waiting.getPiece());
				board.boxes[waiting.getX()][waiting.getY()].setPiece(null);
//				board.boxes[waiting.getX()][waiting.getY()].repaint();
				clicked = false;
//				update(getGraphics());
				System.out.println(board.boxes[waiting.getX()][waiting.getY()]);
				System.out.println(current);
			}
		} else {
			if (current.getPiece() != null && current.getPiece().isWhite()) {
				waiting = current;
				clicked = true;
				System.out.println(current);
			}
		}
	}
}
