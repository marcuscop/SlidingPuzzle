package example.sliding.model;

public class Piece {
	/*
	 * 1: small square
	 * 2: tall rect
	 * 3: wide rect
	 * 4: big square
	 * */
	
	int length;
	int width;
	Coordinate topLeft;
	Coordinate bottomRight;
	
	public Piece(int width, int length, Coordinate topLeft, Coordinate bottomRight) {
		this.length = length;
		this.width = width;
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	public Coordinate getTopLeft() {
		return this.topLeft;
	}
	
	public Coordinate getBottomRight() {
		return this.bottomRight;
	}
	
	public void setCoordinates(Coordinate topLeft, Coordinate bottomRight) {
		this.topLeft.horizontalIndex = topLeft.horizontalIndex;
		this.topLeft.verticalIndex = topLeft.verticalIndex;
		this.bottomRight.horizontalIndex = bottomRight.horizontalIndex;
		this.bottomRight.verticalIndex = bottomRight.verticalIndex;
	}

	public int getWidth() {
		return this.width;
	}
	
	public int getLength() {
		return this.length;
	}

}
