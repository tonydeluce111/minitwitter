package us.deluce.minitwitter;

import java.awt.Dimension; 
import javax.swing.*; 
import javax.swing.tree.*; 


public class AdminTreeUI extends JPanel { 
	
	private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("ROOT");
 
	public AdminTreeUI() { 	
 		Dimension disp = getPreferredSize(); 
 		disp.width = 275; 
 		setPreferredSize(disp); 
 		setBorder(BorderFactory.createTitledBorder("TREE VIEW"));  		
 		JTree tree = null; 
 		tree = addTree(tree, rootNode, 10); 
 		JScrollPane scrollBox = new JScrollPane(tree); 
		addScrollBox(scrollBox, 250, 320); 		
 	} 

 	private JTree addTree(JTree tree, DefaultMutableTreeNode root, int rows) { 
 		tree = new JTree(root); 
  		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); 
  		tree.setVisibleRowCount(rows); 
 		return tree; 
 	} 

 	private void addScrollBox(JScrollPane box, int width, int height) { 
 		Dimension size = box.getPreferredSize(); 
 		size.width = width; 
 		size.height = height; 
 		box.setPreferredSize(size); 
 		add(box); 
 	} 
 	
 } 
 


