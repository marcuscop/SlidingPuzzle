package example.sliding.controller;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.model.Coordinate;
import example.sliding.model.Model;
import example.sliding.model.Piece;

public class MovePieceController{
	SlidingPuzzleApp app;
	Model model;
	
	public MovePieceController(SlidingPuzzleApp app, Model model) {
		this.app = app;
		this.model = model;
	} 
	
	// returns index of selected piece in puzzle list, 0 if none selected
	public int checkSelected() {
		if(model.getPuzzle().getSelected() == null) {
			return 100;
		} else {
			for(int i=0;i<model.getPuzzle().getPieces().size();i++) {
				if(model.getPuzzle().getPieces().get(i).getTopLeft().getHIndex() == model.getPuzzle().getSelected().getTopLeft().getHIndex() &&
						model.getPuzzle().getPieces().get(i).getTopLeft().getVIndex() == model.getPuzzle().getSelected().getTopLeft().getVIndex() ) {
					return i;
				}
			}
		}
		
		return 100;
		
	}
	
	// check to see if theres a selected piece
	// check to make sure its not against the edge
	// check the left direction to see if there is a vacancy
	// change the board
	// move the piece
	// update selected
	public void moveLeft() {
		// check to see if theres a selected piece
		int indexOfPiece = this.checkSelected();
		Piece piece = model.getPuzzle().getPieces().get(indexOfPiece);
		// don't move
		if(indexOfPiece == 100) { return; }
		
		// check to make sure its not against the edge
		if(piece.getTopLeft().getHIndex() == 0) {
			return;
		}
			
		// check the left direction to see if there is a vacancy
		if(model.getPuzzle().getBoard()[piece.getTopLeft().getHIndex()-1][piece.getTopLeft().getVIndex()] == 0 &&
				model.getPuzzle().getBoard()[piece.getTopLeft().getHIndex()-1][piece.getBottomRight().getVIndex()] == 0) {
			// change the board
			for(int i=piece.getTopLeft().getHIndex();i<=piece.getBottomRight().getHIndex();i++) {
				for(int j=piece.getTopLeft().getVIndex();j<=piece.getBottomRight().getVIndex();j++) {
					model.getPuzzle().getBoard()[i-1][j] = 1;
				}
			}
			for(int j=piece.getTopLeft().getVIndex();j<=piece.getBottomRight().getVIndex();j++) {
				model.getPuzzle().getBoard()[piece.getBottomRight().getHIndex()][j] = 0;
			}
			// move the piece
			Coordinate topLeft = new Coordinate(piece.getTopLeft().getHIndex()-1, piece.getTopLeft().getVIndex());
			Coordinate bottomRight = new Coordinate(piece.getBottomRight().getHIndex()-1, piece.getBottomRight().getVIndex());
			model.getPuzzle().getPieces().get(indexOfPiece).setCoordinates(topLeft, bottomRight);
			// update selected
			model.getPuzzle().selectPiece(model.getPuzzle().getPieces().get(indexOfPiece));
		
			// inc moves
			model.getPuzzle().incMoves();
		}
		
	}
	
	public void moveRight() {
		// check to see if theres a selected piece
		int indexOfPiece = this.checkSelected();
		Piece piece = model.getPuzzle().getPieces().get(indexOfPiece);
		// don't move
		if(indexOfPiece == 100) { return; }
		
		// check to make sure its not against the edge
		if(piece.getBottomRight().getHIndex() == 3) {
			return;
		}
		
		// check the right direction to see if there is a vacancy
		if(model.getPuzzle().getBoard()[piece.getBottomRight().getHIndex()+1][piece.getTopLeft().getVIndex()] == 0 &&
				model.getPuzzle().getBoard()[piece.getBottomRight().getHIndex()+1][piece.getBottomRight().getVIndex()] == 0) {
			// change the board
			for(int i=piece.getTopLeft().getHIndex();i<=piece.getBottomRight().getHIndex();i++) {
				for(int j=piece.getTopLeft().getVIndex();j<=piece.getBottomRight().getVIndex();j++) {
					model.getPuzzle().getBoard()[i+1][j] = 1;
				}
			}
			for(int j=piece.getTopLeft().getVIndex();j<=piece.getBottomRight().getVIndex();j++) {
					model.getPuzzle().getBoard()[piece.getTopLeft().getHIndex()][j] = 0;
			}
			
			// change the pieces coordinates
						Coordinate topLeft = new Coordinate(piece.getTopLeft().getHIndex()+1, piece.getTopLeft().getVIndex());
						Coordinate bottomRight = new Coordinate(piece.getBottomRight().getHIndex()+1, piece.getBottomRight().getVIndex());
						model.getPuzzle().getPieces().get(indexOfPiece).setCoordinates(topLeft, bottomRight);
			// update selected
			model.getPuzzle().selectPiece(model.getPuzzle().getPieces().get(indexOfPiece));
		
			// inc moves
			model.getPuzzle().incMoves();
		}
		
	}

	public void moveUp() {
		// check to see if theres a selected piece
		int indexOfPiece = this.checkSelected();
		Piece piece = model.getPuzzle().getPieces().get(indexOfPiece);
		// don't move
		if(indexOfPiece == 100) { return; }
		
		// check to make sure its not against the edge
		if(piece.getTopLeft().getVIndex() == 0) {
			return;
		}
			
		// check the up direction to see if there is a vacancy
		if(model.getPuzzle().getBoard()[piece.getTopLeft().getHIndex()][piece.getTopLeft().getVIndex()-1] == 0 &&
				model.getPuzzle().getBoard()[piece.getBottomRight().getHIndex()][piece.getTopLeft().getVIndex()-1] == 0) {
			// change the board
			for(int i=piece.getTopLeft().getHIndex();i<=piece.getBottomRight().getHIndex();i++) {
				for(int j=piece.getTopLeft().getVIndex();j<=piece.getBottomRight().getVIndex();j++) {
					model.getPuzzle().getBoard()[i][j-1] = 1;
				}
			}
			for(int j=piece.getTopLeft().getHIndex();j<=piece.getBottomRight().getHIndex();j++) {
				model.getPuzzle().getBoard()[j][piece.getBottomRight().getVIndex()] = 0;
			}
			
			// change the pieces coordinates
			Coordinate topLeft = new Coordinate(piece.getTopLeft().getHIndex(), piece.getTopLeft().getVIndex()-1);
			Coordinate bottomRight = new Coordinate(piece.getBottomRight().getHIndex(), piece.getBottomRight().getVIndex()-1);
			model.getPuzzle().getPieces().get(indexOfPiece).setCoordinates(topLeft, bottomRight);
			// update selected
			model.getPuzzle().selectPiece(model.getPuzzle().getPieces().get(indexOfPiece));
		
			// inc moves
			model.getPuzzle().incMoves();
		} 

	}

	public void moveDown() {
		// check to see if theres a selected piece
		int indexOfPiece = this.checkSelected();
		Piece piece = model.getPuzzle().getPieces().get(indexOfPiece);

		// don't move
		if(indexOfPiece == 100) { return; }
		
		// check to make sure its not against the edge
		if(piece.getTopLeft().getVIndex() == 4) {
			return;
		}
		
		
		// check the down direction to see if there is a vacancy
		if(model.getPuzzle().getBoard()[piece.getTopLeft().getHIndex()][piece.getBottomRight().getVIndex()+1] == 0 &&
				model.getPuzzle().getBoard()[piece.getBottomRight().getHIndex()][piece.getBottomRight().getVIndex()+1] == 0) {
			// change the board
			for(int i=piece.getTopLeft().getHIndex();i<piece.getBottomRight().getHIndex()+1;i++) {
				for(int j=piece.getTopLeft().getVIndex();j<piece.getBottomRight().getVIndex()+1;j++) {
					model.getPuzzle().getBoard()[i][j+1] = 1;
				}
			}
			for(int j=piece.getTopLeft().getHIndex();j<=piece.getBottomRight().getHIndex();j++) {
				model.getPuzzle().getBoard()[j][piece.getTopLeft().getVIndex()] = 0;
			}
			// change the pieces coordinates
			Coordinate topLeft = new Coordinate(piece.getTopLeft().getHIndex(), piece.getTopLeft().getVIndex()+1);
			Coordinate bottomRight = new Coordinate(piece.getBottomRight().getHIndex(), piece.getBottomRight().getVIndex()+1);
			model.getPuzzle().getPieces().get(indexOfPiece).setCoordinates(topLeft, bottomRight);
			// update selected
			model.getPuzzle().selectPiece(model.getPuzzle().getPieces().get(indexOfPiece));
			
			// inc moves
			model.getPuzzle().incMoves();
			
		} 
		
	}

}
