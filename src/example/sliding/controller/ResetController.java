package example.sliding.controller;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.model.Coordinate;
import example.sliding.model.Model;
import example.sliding.model.Piece;

public class ResetController {
	SlidingPuzzleApp app;
	Model model;
	
	public ResetController(SlidingPuzzleApp app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void reset() {
		
		// init board to 0
		for(int i=0;i<model.getPuzzle().getDx();i++) {
			for(int j=0;j<model.getPuzzle().getDy();j++) {
				model.getPuzzle().getBoard()[i][j] = 0;
			}
		}
		
		// reset all pieces to init configuration
		Coordinate tl = new Coordinate(0,0);
		Coordinate br = new Coordinate(0,1);
		model.getPuzzle().getPieces().get(0).setCoordinates(tl, br);
		
		tl = new Coordinate(1,0);
		br = new Coordinate(2,1);
		model.getPuzzle().getPieces().get(1).setCoordinates(tl, br);
				
		tl = new Coordinate(3,0);
		br = new Coordinate(3,1);
		model.getPuzzle().getPieces().get(2).setCoordinates(tl, br);
		
		tl = new Coordinate(0,2);
		br = new Coordinate(0,3);
		model.getPuzzle().getPieces().get(3).setCoordinates(tl, br);
		
		tl = new Coordinate(0,4);
		br = new Coordinate(0,4);
		model.getPuzzle().getPieces().get(4).setCoordinates(tl, br);
		
		tl = new Coordinate(1,2);
		br = new Coordinate(2,2);
		model.getPuzzle().getPieces().get(5).setCoordinates(tl, br);
		
		tl = new Coordinate(1,3);
		br = new Coordinate(1,3);
		model.getPuzzle().getPieces().get(6).setCoordinates(tl, br);
		
		tl = new Coordinate(2,3);
		br = new Coordinate(2,3);
		model.getPuzzle().getPieces().get(7).setCoordinates(tl, br);
		
		tl = new Coordinate(3,2);
		br = new Coordinate(3,3);
		model.getPuzzle().getPieces().get(8).setCoordinates(tl, br);
		
		tl = new Coordinate(3,4);
		br = new Coordinate(3,4);
		model.getPuzzle().getPieces().get(9).setCoordinates(tl, br);
		
		// change the board
		for(int p=0;p<model.getPuzzle().getPieces().size();p++) {
					
			for(int ppx=model.getPuzzle().getPieces().get(p).getTopLeft().getHIndex();ppx<=model.getPuzzle().getPieces().get(p).getBottomRight().getHIndex();ppx++) {
				for(int ppy=model.getPuzzle().getPieces().get(p).getTopLeft().getVIndex();ppy<=model.getPuzzle().getPieces().get(p).getBottomRight().getVIndex();ppy++) {
					model.getPuzzle().getBoard()[ppx][ppy] = 1;
				}
			}
					
		}
		
		// reset to no selected
		model.getPuzzle().selectPiece(null);
		
		// reset moves counter
		model.getPuzzle().resetMoves();	
	
	}
	
}
