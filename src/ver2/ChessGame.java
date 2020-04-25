package ver2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ChessGame extends JFrame {
	private JPanel contentPane;
	private ChessPanel chessPanel;
	
	
	public ChessGame() {
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		chessPanel = new ChessPanel();
		
		contentPane.add(chessPanel, BorderLayout.CENTER);
		
//		pack();
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ChessGame game = new ChessGame();
				game.setVisible(true);
			}
		});
	}
}
