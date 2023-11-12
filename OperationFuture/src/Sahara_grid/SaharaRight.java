package Sahara_grid;

import Grids.Grid;
import Grids.grid_boxes;

public class SaharaRight extends Grid {

	public SaharaRight() {
		
		name = "Shara Right";
		
		//setExits(grid_boxes UpExit, grid_boxes DownExit, grid_boxes RightExit, grid_boxes LeftExit)
		setExits(grid_boxes.WALL, grid_boxes.WALL, grid_boxes.WALL, grid_boxes.CENTER);
	}
	
	

}
