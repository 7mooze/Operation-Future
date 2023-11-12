package Sahara_grid;

import java.util.ArrayList;
import java.util.Arrays;

import Grids.Grid;


public class SaharaGrid {
		
	public static ArrayList <Grid> grid = new ArrayList<>(Arrays.asList(new SaharaCenter(), new SaharaUp(),new SaharaDown(),new SaharaRight(), new SaharaLeft()));
		
}