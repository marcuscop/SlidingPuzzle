package example.sliding.model;

import java.util.ArrayList;

public class Puzzle {
	
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	int[][] board = new int[4][5]; // 0 for empty // 1 for not empty
	Piece selectedPiece;
	int dx = 4;
	int dy = 5;
	int moves = 0;
	String win_moves = "";
	
	public Puzzle() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				this.board[i][j] = 0;
			}
		}
	}
	
	public void incMoves() {
		this.moves = this.moves+1;
	}
	
	public String getMoves() {
		return Integer.toString(this.moves);
	}
	
	public void setWinMoves() {
		this.win_moves = this.getMoves();
	}
	
	public String getWinMoves() {
		return this.win_moves;
	}

	public int getDx() {
		return this.dx;
	}
	
	public void resetMoves() {
		this.moves = 0;
	} 
	
	public int getDy() {
		return this.dy;
	}
	
	//Adds a piece to the puzzle
	public void addPiece(Piece piece) {

		// add the piece to the list of pieces
		this.pieces.add(piece);
		// add the piece to the virtual representation of the board
		for(int i=piece.getTopLeft().getHIndex();i<=piece.getBottomRight().getHIndex();i++) {
			for(int j=piece.getTopLeft().getVIndex();j<=piece.getBottomRight().getVIndex();j++) {
				this.board[i][j] = 1;
			}
		}
	}

	// returns list of pieces
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	// returns board 2d array
	public int[][] getBoard(){
		return this.board;
	}

	// returns selected piece
	public Piece getSelected() {
		return this.selectedPiece;
	}

	// changes selected piece
	public void selectPiece(Piece piece) {
		this.selectedPiece = piece;
	}

	public boolean checkWin() {
		for(int i=0;i<this.getPieces().size();i++) {
			if(this.getPieces().get(i).getLength() == 2 && this.getPieces().get(i).getWidth() == 2) {
				if(this.getPieces().get(i).getTopLeft().getHIndex() == 1 && 
						this.getPieces().get(i).getTopLeft().getVIndex() == 3) {
					this.setWinMoves();
					return true;
				}
			}
			
		}
		return false;
	}
}
