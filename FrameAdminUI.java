package us.deluce.minitwitter;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class FrameAdminUI extends JFrame {
	
	private ButtonAdminUI buttons; 
    private AdminTreeUI treeView; 

    public FrameAdminUI() {    
    	setLayout(new BorderLayout()); 
    	buttons = new ButtonAdminUI(); 
    	treeView = new AdminTreeUI(); 		 
    	Container window = getContentPane();  
    	window.add(treeView, BorderLayout.WEST); 
    	window.add(buttons, BorderLayout.EAST); 	
	} 

}