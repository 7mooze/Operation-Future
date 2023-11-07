package Characters;

import UI.UI;

public class HQ extends Character implements Runnable{

	private Thread hq;
	private UI ui;
	
	public HQ(UI ui) {
		this.ui=ui;
		
		hq = new Thread (this);
		hq.start();
	}
	
	private static HQ instance;
	
	public static synchronized HQ getInstance(UI ui){
	       if(instance == null){
	           instance = new HQ(ui);
	       }
	       return instance;
	   }
	

	@Override
	public void talk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
