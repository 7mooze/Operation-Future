package Grids;

public enum grid_boxes {
	
	CENTER (0),
	UP(1),
	DOWN(2),
	RIGHT(3),
	LEFT (4),
	WALL (-1);
	
	int grid_index;
	
	
	public int getGridIndex() {
		
		return this.grid_index;
	}
	
	grid_boxes (int grid_index){
		this.grid_index = grid_index;
	}

}
