package Map;

import Scenes.HQ_;

public class Map {
	
	
private State state = new HQ_();
	
	public void previousState(){
		state.prev(this);
	}
	
	public void nextState() { 
		state.next(this); 
		}
	
	public void printStatus() { 
		state.printStatus(); 
	}
	
	public void setState(State state) {
			this.state = state;
	}

}
