package example.sliding.model;

public class Coordinate {

	int horizontalIndex;
	int verticalIndex;
	
	public Coordinate(int horizontalIndex, int verticalIndex){	
		this.horizontalIndex = horizontalIndex;
		this.verticalIndex = verticalIndex;
	}
	
	public int getHIndex() {
		return this.horizontalIndex;
	}
	
	public int getVIndex(){
		return this.verticalIndex;
	}
	
}
