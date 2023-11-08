package Map;

public enum game_locations {
	
	HQ (0),
	SAHARA(1),
	NIGHT(2),
	PROMINENT(3),
	PACIFIC (4),
	ANTARCTICA (5),
	HIDDEN (6);
	
	int location_index;
	
	
	public int getLocationIndex() {
		
		return this.location_index;
	}
	
	game_locations(int location_index){
		this.location_index = location_index;
	}

}
