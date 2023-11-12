package Sahara_grid;

import Grids.Grid;
import Grids.grid_boxes;

public class SaharaDown extends Grid {

	public SaharaDown() {
		name = "Shara Down";
		
		setExits(grid_boxes.CENTER, grid_boxes.WALL, grid_boxes.CENTER, grid_boxes.WALL);
	}
	
	

}
