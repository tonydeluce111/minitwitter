package us.deluce.minitwitter;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;

public class FrameUserUI extends JFrame { 
 
	private ListUserUI listUserUI;
 	private ButtonUserUI buttonUserUI; 
 	  
 
 	public FrameUserUI(User u, TwitterTree tree) { 
 		getContentPane().setLayout(new BorderLayout()); 
 		buttonUserUI = new ButtonUserUI(u, tree); 
 		listUserUI = new ListUserUI(); 
 		Container window = getContentPane(); 
  		window.add(listUserUI, BorderLayout.CENTER); 
 		window.add(buttonUserUI, BorderLayout.NORTH); 
 	} 
} 