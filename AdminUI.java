package us.deluce.minitwitter;

import javax.swing.JFrame;

public class AdminUI { 

	public AdminUI() { 
		JFrame frame = new FrameAdminUI(); 
		frame.setSize(600, 400); 
		frame.setVisible(true); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 	} 

 } 