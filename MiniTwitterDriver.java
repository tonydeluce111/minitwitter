package us.deluce.minitwitter;

import java.awt.EventQueue;

public class MiniTwitterDriver {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {				
				public void run() {	
					MiniTwitter.getInstance(); 
				}
		});
				
	}

}