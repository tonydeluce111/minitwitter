package us.deluce.minitwitter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class UserUI { 
 
 	public UserUI(User usr, TwitterTree tree) { 
 		SwingUtilities.invokeLater(new Runnable() { 
 
 			@Override 
 			public void run() { 
 				JFrame frame = new FrameUserUI(usr,tree); 
 				frame.setLocationByPlatform(true);
 				frame.setSize(600, 400); 
				frame.setVisible(true); 
 				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
 			} 
 		}); 
 	} 
 

} 