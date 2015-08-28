package us.deluce.minitwitter;

import java.awt.*; 
import javax.swing.*; 

public class ListUserUI extends JPanel { 
 
 	private DefaultListModel<String> defaultListModelNewsFeed;  
 	private DefaultListModel<String> defaultListModelFollowing; 
 	private GridBagConstraints gridBagConstraints; 
 	private static String[] news = new String[100]; 
 	private static String[] follow = new String[100]; 
 	private static int newsItemCount = 0; 
 	private static int followItemCount = 0; 
 
 
 	public ListUserUI() { 
 		this.gridBagConstraints = new GridBagConstraints();
 		this.defaultListModelNewsFeed = new DefaultListModel<>();
 		defaultListModelFollowing = new DefaultListModel<>();
  		initializeListUserUI(); 
 	} 
 	
 	public void initializeListUserUI() { 		  
 		setLayout(new GridBagLayout()); 
  		JList<String> newsFeed = null; 
 		newsFeed = addAList(newsFeed, 15, 15, 8, defaultListModelNewsFeed); 
  		JList<String> following = null; 
 		following = addAList(following, 15, 15, 8, defaultListModelFollowing); 	
 		JScrollPane scrollBox = null; 
 		setInsets(5, 10, 5, 10); 
 		scrollBox = addAScrollBox(scrollBox, newsFeed, 260, 280, 0, 0); 
 		JScrollPane scrollBox1 = null; 
 		setInsets(5, 10, 5, 10); 
 		scrollBox1 = addAScrollBox(scrollBox1, following, 260, 280, 1, 0); 
 		populateList(news, defaultListModelNewsFeed); 
 		populateList(follow, defaultListModelFollowing); 
 	} 
 
 	public static void refreshView(User usr, TwitterTree tree) { 
		UserUI usrUI = new UserUI(usr, tree); 
	} 
 
 
 	public static void addToNews(String item) { 
 		news[newsItemCount] = item; 
 		newsItemCount++; 
 	} 
 
 	public static void addToFollow(String item) { 
 		follow[followItemCount] = item; 
 		followItemCount++; 
 	} 
 
 	private void populateList(String[] str, DefaultListModel<String> model) { 
 		for (String s : str) { 
 			model.addElement(s); 
 		} 
 	} 
 
 	private JList<String> addAList(JList<String> list, int cellHeight, 
 			int cellWidth, int rows, DefaultListModel<String> model) { 
 		list = new JList<String>(model); 
 		list.setVisibleRowCount(rows); 
 		list.setFixedCellHeight(cellHeight); 
 		list.setFixedCellWidth(cellWidth); 
 		return list; 
 	} 
 	
 	private JScrollPane addAScrollBox(JScrollPane box, JList<String> list, 
 			int width, int height, int xCordinate, int yCordinate) { 
 		box = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
 				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
 		Dimension size = box.getPreferredSize(); 
 		size.width = width; 
 		size.height = height; 
 		box.setPreferredSize(size); 
 		gridBagConstraints.gridx = xCordinate; 
 		gridBagConstraints.gridy = yCordinate; 
 		add(box, gridBagConstraints); 
 		return box; 
 	} 

	private void setInsets(int top, int left, int bottom, int right) { 
 		gridBagConstraints.insets = new Insets(top, left, bottom, right); 
 	} 
	
} 