package Sahara_grid;

import Grids.Grid;
import Grids.grid_boxes;

public class SaharaUp extends Grid{

	public SaharaUp() {
		name = "Sahara Up";
		
		//setExits(grid_boxes UpExit, grid_boxes DownExit, grid_boxes RightExit, grid_boxes LeftExit)
		  setExits(grid_boxes.WALL, grid_boxes.CENTER, grid_boxes.WALL, grid_boxes.WALL);
	}
	
	

}
