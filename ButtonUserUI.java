package us.deluce.minitwitter;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

 
public class ButtonUserUI extends JPanel { 
 
	private GridBagConstraints gridBagConstraints; 
	 
	public ButtonUserUI(User usr, TwitterTree tree) { 
		gridBagConstraints = new GridBagConstraints();	
 		initializeButtonUserUI(usr,tree); 
	} 
 	
	public void initializeButtonUserUI(User usr, TwitterTree tree) { 
		
 		JTextField userIdField = new JTextField(10); 
 		JTextField msgField = new JTextField(10); 
 		JButton followUserBtn = new JButton("Follow"); 
 		JButton postTweet = new JButton("Tweet"); 
 		setLayout(new GridBagLayout()); 
 		gridBagConstraints.weightx = 0.5; 
 		setInsets(10, 10, 5, 10); 
 		addField(userIdField, 2, 0); 
 		addButton(followUserBtn, 3, 0); 
 
 		followUserBtn.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
			String[] name = { userIdField.getText() }; 
 			ListUserUI.addToFollow(name[0]); 
 			ListUserUI.refreshView(usr, tree); 
 		} 
 		}); 
  
 		postTweet.addActionListener(new ActionListener() { 
 		@Override 
 		public void actionPerformed(ActionEvent arg0) { 
 			String[] name = { msgField.getText() }; 
 			usr.isTweetPositive(name[0]);
			usr.tweetMessage(usr.getId(usr) + ": " + name[0]); 
 			ListUserUI.addToNews(usr.getId(usr) + ": " + name[0]); 
 			ListUserUI.refreshView(usr,tree); 
 		} 
 		}); 
 		setInsets(10, 10, 5, 10); 
 		addField(msgField, 0, 0); 
 		addButton(postTweet, 1, 0); 
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
