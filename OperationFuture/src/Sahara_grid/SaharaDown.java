package Sahara_grid;

import java.util.Scanner;

import Grids.Grid;
import Grids.grid_boxes;

public class SaharaDown extends Grid {

	public SaharaDown() {
		name = "Shara Down";
		
		setExits(grid_boxes.CENTER, grid_boxes.WALL, grid_boxes.CENTER, grid_boxes.WALL);
	}
	
	
	Scanner input = new Scanner(System.in);  //takes user input
	
	
	

}
