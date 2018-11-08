package example.sliding.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import example.sliding.controller.SelectPieceController;
import example.sliding.model.Model;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel implements MouseListener{
	
	Model model;
	SlidingPuzzleApp app;

	public PuzzleView(Model model, SlidingPuzzleApp app) {
		this.model = model;
		this.app = app;
		addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("painting");
		super.paintComponent(g);
		
		g.clearRect(0, 0, 400, 500);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,  400, 500);
		
		int alpha = 200; // 50% transparent
		Color myColour = new Color(222, 184, 135);
		Color big = new Color(210, 150, 130);
		
		for(int i=0;i<model.getPuzzle().getPieces().size();i++) {
			myColour = new Color(222,184, 135);
			g.setColor(myColour);
			if(model.getPuzzle().getPieces().get(i).getLength() == 2 && model.getPuzzle().getPieces().get(i).getWidth() == 2) {
				big = new Color(210, 150, 130);
				g.setColor(big);
			} 
			if(model.getPuzzle().getPieces().get(i) == model.getPuzzle().getSelected()) {
				if(model.getPuzzle().getPieces().get(i).getLength() == 2 && model.getPuzzle().getPieces().get(i).getWidth() == 2) {
					big = new Color(210, 150, 130, alpha);
					g.setColor(big);
				} else {
					myColour = new Color(222, 184, 135, alpha);
					g.setColor(myColour);
				}
				
			}
			
			g.fillRect(model.getPuzzle().getPieces().get(i).getTopLeft().getHIndex()*100, 
					model.getPuzzle().getPieces().get(i).getTopLeft().getVIndex()*100, 
					model.getPuzzle().getPieces().get(i).getWidth()*100, 
					model.getPuzzle().getPieces().get(i).getLength()*100);
			g.setColor(Color.GRAY);
			g.drawRect(model.getPuzzle().getPieces().get(i).getTopLeft().getHIndex()*100, 
					model.getPuzzle().getPieces().get(i).getTopLeft().getVIndex()*100, 
					model.getPuzzle().getPieces().get(i).getWidth()*100, 
					model.getPuzzle().getPieces().get(i).getLength()*100);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		new SelectPieceController(app, model).select(e);
		this.repaint();
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
	
	/*public void actionPreformed(ActionEvent e) {
		// check where the selection was? e.something
		// select piece 
	}*/
	
}
