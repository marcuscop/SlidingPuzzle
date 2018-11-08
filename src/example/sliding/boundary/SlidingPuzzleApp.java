package example.sliding.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.sliding.controller.MovePieceController;
import example.sliding.controller.ResetController;
import example.sliding.controller.SelectPieceController;
import example.sliding.model.Coordinate;
import example.sliding.model.Model;
import example.sliding.model.Piece;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class SlidingPuzzleApp extends JFrame {

	Model model;
	private JPanel contentPane;
	PuzzleView panel;
	JButton btnReset;
	JButton btnUp;
	JButton btnLeft;
	JButton btnRight;
	JButton btnDown;
	JLabel lblMoves;
	JLabel label;
	JLabel label_1;
	boolean win = false;
	private JLabel lblSlidingPuzzle;
	private JLabel lblGetTheRed;
	private JLabel lblBottom;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		Model model = new Model();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlidingPuzzleApp frame = new SlidingPuzzleApp(model);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SlidingPuzzleApp(Model model) {
		this.model = model;
		
		setTitle("SlidingPuzzleApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 80, 730, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// add a puzzle and pieces
		Coordinate tl = new Coordinate(0,0);
		Coordinate br = new Coordinate(0,1);
		Piece tall1 = new Piece(1, 2, tl, br);
		model.getPuzzle().addPiece(tall1);
		
		tl = new Coordinate(1,0);
		br = new Coordinate(2,1);
		Piece WIN_PIECE = new Piece(2, 2, tl, br);
		model.getPuzzle().addPiece(WIN_PIECE);
				
		tl = new Coordinate(3,0);
		br = new Coordinate(3,1);
		Piece tall2 = new Piece(1, 2, tl, br);
		model.getPuzzle().addPiece(tall2);
		
		tl = new Coordinate(0,2);
		br = new Coordinate(0,3);
		Piece tall3 = new Piece(1, 2, tl, br);
		model.getPuzzle().addPiece(tall3);
		
		tl = new Coordinate(0,4);
		br = new Coordinate(0,4);
		Piece short1 = new Piece(1, 1, tl, br);
		model.getPuzzle().addPiece(short1);
		
		tl = new Coordinate(1,2);
		br = new Coordinate(2,2);
		Piece wide1 = new Piece(2, 1, tl, br);
		model.getPuzzle().addPiece(wide1);
		
		tl = new Coordinate(1,3);
		br = new Coordinate(1,3);
		Piece short2 = new Piece(1, 1, tl, br);
		model.getPuzzle().addPiece(short2);
		
		tl = new Coordinate(2,3);
		br = new Coordinate(2,3);
		Piece short3 = new Piece(1, 1, tl, br);
		model.getPuzzle().addPiece(short3);
		
		tl = new Coordinate(3,2);
		br = new Coordinate(3,3);
		Piece long4 = new Piece(1, 2, tl, br);
		model.getPuzzle().addPiece(long4);
		
		tl = new Coordinate(3,4);
		br = new Coordinate(3,4);
		Piece short4 = new Piece(1, 1, tl, br);
		model.getPuzzle().addPiece(short4);
		
		//System.out.println(model.getPuzzle().getPieces().get(0).getLength());
		
		panel = new PuzzleView(model, this);
		panel.setBackground(Color.GRAY);
		panel.setSize(new Dimension(400, 500));
		
		btnReset = new JButton("Reset");
		//btnReset.setEnabled(false); // until values are entered
		// Added code to register action listener handler that invokes controller. 
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetController(SlidingPuzzleApp.this, model).reset();
				panel.repaint();
				label.setText("0");
				label_1.setText("");
			}
		});
		
		btnUp = new JButton("^");
		//btnUp.setEnabled(false); // until values are entered
		// Added code to register action listener handler that invokes controller. 
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(SlidingPuzzleApp.this, model).moveUp();
				panel.repaint();
				label.setText(model.getPuzzle().getMoves());
				win = model.getPuzzle().checkWin();
				if(win) {
					label_1.setText("YOU WON in " + model.getPuzzle().getWinMoves() + " moves!");
				}
			}
		});
		
		btnLeft = new JButton("<");
		//btnLeft.setEnabled(false); // until values are entered
		// Added code to register action listener handler that invokes controller. 
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(SlidingPuzzleApp.this, model).moveLeft();
				panel.repaint();
				label.setText(model.getPuzzle().getMoves());
				win = model.getPuzzle().checkWin();
				if(win) {
					label_1.setText("YOU WON in " + model.getPuzzle().getWinMoves() + " moves!");
				}
			}
		});
		
		btnRight = new JButton(">");
		//btnRight.setEnabled(false); // until values are entered
		// Added code to register action listener handler that invokes controller. 
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(SlidingPuzzleApp.this, model).moveRight();
				panel.repaint();
				label.setText(model.getPuzzle().getMoves());
				win = model.getPuzzle().checkWin();
				if(win) {
					label_1.setText("YOU WON in " + model.getPuzzle().getWinMoves() + " moves!");
				}
			}
		});
		
		btnDown = new JButton("V");
		//btnDown.setEnabled(false); // until values are entered
		// Added code to register action listener handler that invokes controller. 
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(SlidingPuzzleApp.this, model).moveDown();
				panel.repaint();
				label.setText(model.getPuzzle().getMoves());
				win = model.getPuzzle().checkWin();
				if(win) { 
					label_1.setText("YOU WON in " + model.getPuzzle().getWinMoves() + " moves!");
				}
			}
		});
		
		lblMoves = new JLabel("Moves:");
		
		label = new JLabel("0");
		
		label_1 = new JLabel("");
		
		lblSlidingPuzzle = new JLabel("Sliding Puzzle");
		lblSlidingPuzzle.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		
		lblGetTheRed = new JLabel("Slide the red block out the middle");
		
		lblBottom = new JLabel("bottom.");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblGetTheRed))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMoves)
									.addGap(6)
									.addComponent(label))
								.addComponent(lblBottom)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLeft)
									.addGap(18)
									.addComponent(btnRight))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(48)
									.addComponent(btnDown))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(47)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnReset)
										.addComponent(btnUp)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(lblSlidingPuzzle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSlidingPuzzle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGetTheRed)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBottom)
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)
							.addGap(99)
							.addComponent(label_1)
							.addGap(101)
							.addComponent(btnUp)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLeft)
								.addComponent(btnRight))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDown)))
					.addGap(301))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
