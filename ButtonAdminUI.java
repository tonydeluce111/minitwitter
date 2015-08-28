package us.deluce.minitwitter;

import java.awt.Dimension; 
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.Insets; 
import java.awt.event.*; 
import javax.swing.*; 

public class ButtonAdminUI extends JPanel { 

private GridBagConstraints gridBagConstraints;  

public ButtonAdminUI() { 	
	gridBagConstraints = new GridBagConstraints();	
	initializeButtonAdminUI(); 
} 
 
private void initializeButtonAdminUI() { 
	Dimension size = getPreferredSize(); 
	size.width = 300; 
	size.height = 400; 
	setPreferredSize(size); 
	
	TwitterTree tree = new TwitterTree();
	User me = new User("Tony DeLuce", tree);
	User.initPositiveTweetWords();
 
	JTextField groupIdField = new JTextField(10); 
	JTextField userIdField = new JTextField(10); 
 
	JButton addUserBtn = new JButton("Add User"); 
 	JButton addGroupBtn = new JButton("Add UserGroup"); 
 	JButton openUserViewBtn = new JButton("Open User View"); 
 	JButton showTotUserBtn = new JButton("Total Users"); 
 	JButton showTotGroupBtn = new JButton("Total Groups"); 
 	JButton showTotMsgBtn = new JButton("Total Messages"); 
 	JButton showPosPercentBtn = new JButton("Positive Percentage"); 
 	
 	setLayout(new GridBagLayout()); 
 	gridBagConstraints.weightx = 0.5; 
        
 	setInsets(5, 5, 5, 5); 
	addField(userIdField, 0, 0); 
 	addButton(addUserBtn, 1, 0); 
 	addField(groupIdField, 0, 1); 
 	addButton(addGroupBtn, 1, 1); 
  	gridBagConstraints.gridwidth = 3; 
 	setInsets(5, 5, 5, 5); 
 	addButton(openUserViewBtn, 0, 2); 
 	gridBagConstraints.gridwidth = 1; 
 	setInsets(5, 5, 5, 5); 
 	addButton(showTotUserBtn, 0, 4); 
 	addButton(showTotMsgBtn, 1, 4); 
 	addButton(showTotGroupBtn, 0, 5); 
 	addButton(showPosPercentBtn, 1, 5); 
 	
	addUserBtn.addActionListener(new ActionListener() { 
  		@Override 
		public void actionPerformed(ActionEvent arg0) { 
			String[] name = { userIdField.getText() }; 
			User newUser = new User(name[0], tree); 
			tree.add(newUser);			
		} 
 	}); 
 
 	addGroupBtn.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
 			String[] name = { groupIdField.getText() }; 
 			UserGroup newGroup = new UserGroup(name[0]); 
 			tree.add(newGroup);
 		} 
 	}); 
 
 	openUserViewBtn.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
 			UserUI uui = new UserUI(me,tree); 
 		} 
 	}); 
 	
 	showTotUserBtn.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
 			System.out.println("Number of Users in MiniTwitter: " + TotalNumberOfUsers.totalNumberOfUsers() );			
 		} 
 	}); 
 	  
 	showTotGroupBtn.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
 		 System.out.println("Number of Groups in MiniTwitter: " + TotalNumberOfGroups.totalNumberOfGroups());
 		} 
 	}); 
 	
 	showTotMsgBtn.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
 			System.out.println("Total Number of Messages: " + TotalNumberOfMessages.totalNumberOfMessages());
 		} 
 	}); 
  
 	showPosPercentBtn.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
 			System.out.println("Total Number of Positive Tweets: " + TotalPercentagePositiveMessages.totalNumberOfPositiveMessages() + "%");
 		} 
 	}); 
 	 
 } 
 
 	private void addField(JTextField field, int xCordinate, int yCordinate) { 
 		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; 
 		gridBagConstraints.gridx = xCordinate; 
 		gridBagConstraints.gridy = yCordinate; 
 		add(field, gridBagConstraints); 
 	} 
 
 	private void addButton(JButton button, int xCordinate, int yCordinate) { 
 	  	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; 
 	    gridBagConstraints.gridx = xCordinate; 
 		gridBagConstraints.gridy = yCordinate; 
 		add(button, gridBagConstraints); 
 	} 
 
 	private void setInsets(int top, int left, int bottom, int right) { 
 		gridBagConstraints.insets = new Insets(top, left, bottom, right); 
 	}	

 } 
 
