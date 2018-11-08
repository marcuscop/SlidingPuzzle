package example.sliding.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.model.Coordinate;
import example.sliding.model.Model;
import example.sliding.model.Piece;

public class SelectPieceController {
	SlidingPuzzleApp app;
	Model model;
	
	public SelectPieceController(SlidingPuzzleApp app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void select(MouseEvent e) {
		// find piece from action event
		int x = e.getX()/100;
		int y = e.getY()/100;		
		
		// find the piece that is at that spot
		for(int i=0; i<model.getPuzzle().getPieces().size();i++) {
			
			for(int j=model.getPuzzle().getPieces().get(i).getTopLeft().getHIndex();j<=model.getPuzzle().getPieces().get(i).getBottomRight().getHIndex();j++) {
				for(int k=model.getPuzzle().getPieces().get(i).getTopLeft().getVIndex();k<=model.getPuzzle().getPieces().get(i).getBottomRight().getVIndex();k++) {
					// check if piece's sectors is in the same spot as mouse click
					// j is x && k is y
					if(j == x && k == y) {
						// change the piece to be selected
						model.getPuzzle().selectPiece(model.getPuzzle().getPieces().get(i));
						
					}
				} // for
			} // for
			
		} // for
		
		
	}
}
