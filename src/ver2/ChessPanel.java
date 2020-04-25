package ver2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChessPanel extends JPanel implements MouseListener {
	private Rectangle2D[][] cells;
	private String[][] pieceOnBoard;
	private Map<String, Image> images;
	private final int size = 8;
	private final int cell_size = 75;

	public ChessPanel() {
		// Create board
		cells = new Rectangle2D[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cells[i][j] = new Rectangle2D.Double(j * cell_size, i * cell_size, cell_size, cell_size);
			}
		}
		
		// Get image Piece
		Map<String, Image> images = new HashMap<String, Image>();
//		Set<String> imgNames = new HashSet<String>(
//				Arrays.asList("wk", "wq", "wb", "wk", "wr", "wp", "bk", "bq", "bb", "bk", "br", "bp"));
		Set<String> imgNames = new HashSet<String>(
				Arrays.asList("wp", "bp"));
		for(String imgName : imgNames) {
			File imgFile = new File("./img/" + imgName + ".jpg");
			
			try {
				Image img = ImageIO.read(imgFile).getScaledInstance(cell_size, cell_size, Image.SCALE_SMOOTH);
				images.put(imgName, img);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Create Piece on Board
		pieceOnBoard = new String[size][size];
		for(int i = 0; i < 8; i++) {
			pieceOnBoard[1][i] = "bp";
		}
		for(int i = 0; i < 8; i++) {
			pieceOnBoard[6][i] = "wp";
		}

	}

	private void readImage() {
		Map<String, Image> images = new HashMap<String, Image>();
//		Set<String> imgNames = new HashSet<String>(
//				Arrays.asList("wk", "wq", "wb", "wkn", "wr", "wp", "bk", "bq", "bb", "bkn", "br", "bp"));
		Set<String> imgNames = new HashSet<String>(
				Arrays.asList("wp", "bp"));
		for(String imgName : imgNames) {
			File imgFile = new File("./img/" + imgName + ".jpg");
			
			try {
				Image img = ImageIO.read(imgFile).getScaledInstance(cell_size, cell_size, Image.SCALE_SMOOTH);
				images.put(imgName, img);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void drawBoard(Graphics2D g2d) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if ((i + j) % 2 == 0) {
					g2d.setColor(Color.WHITE);
				} else {
					g2d.setColor(Color.BLACK);
				}
				g2d.fill(cells[i][j]);
			}
		}
	}

	private void drawPiece(Graphics2D g2d) {
		Map<String, Image> images = new HashMap<String, Image>();
		Set<String> imgNames = new HashSet<String>(
				Arrays.asList("wk", "wq", "wb", "wkn", "wr", "wp", "bk", "bq", "bb", "bkn", "br", "bp"));
		for(String imgName : imgNames) {
			File imgFile = new File("./img/" + imgName + ".jpg");
			
			try {
				Image img = ImageIO.read(imgFile).getScaledInstance(cell_size, cell_size, Image.SCALE_SMOOTH);
				images.put(imgName, img);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(pieceOnBoard[i][j] != null) {
					g2d.drawImage(images.get(pieceOnBoard[i][j]), cell_size * j, cell_size * i, null);
				}
			}
		}
		// Rook
		g2d.drawImage(images.get("br"), 0, 0, null);
		g2d.drawImage(images.get("wr"), 0, cell_size * 7, null);
		g2d.drawImage(images.get("br"), cell_size * 7, 0, null);
		g2d.drawImage(images.get("wr"), cell_size * 7, cell_size * 7, null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		drawBoard((Graphics2D) g);
		drawPiece((Graphics2D) g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		Point current = e.getX
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
