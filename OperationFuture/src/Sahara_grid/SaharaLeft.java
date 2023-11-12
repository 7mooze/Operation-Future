package Sahara_grid;

import Grids.Grid;
import Grids.grid_boxes;

public class SaharaLeft extends Grid {

	public SaharaLeft() {
		name = "Shara Left";
		
		setExits(grid_boxes.WALL, grid_boxes.WALL, grid_boxes.CENTER, grid_boxes.WALL);
	}
	
	

}
