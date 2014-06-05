package tanks.controller;

import tanks.gui.FieldPanel;

public class Controller implements Runnable {
	
	private final int FPS = 60;
	
	private FieldPanel 				fieldPanel;
	private Thread 					thread;
	//private ArrayList<GameObject> 	objects;
	
	public Controller(FieldPanel fp) {
		fieldPanel 	= fp;
		thread 		= new Thread(this);
		//objects		= new ArrayList<GameObject>();
		thread.start();
	}
	
	private void createField() {
		// Create all crates
		
		// Create all tanks
		
	}

	public void run() {
		while(true) {
			fieldPanel.repaint();		
			try {
				Thread.sleep(1000/FPS);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
