package us.deluce.minitwitter;

import java.util.ArrayList;
import java.util.List;

public class User extends Subject implements Component, Observer, Visitable {

	private String uniqueUserId;
	private List<String> following;
	private List<String> followers;
	private List<String> newsFeed;
	private String message; // just the latest message of the newsFeed - used for simplification
	
	private static int numberOfUsers = 0;
	private static int totalNumberMessages = 0;
	private static int totalNumberPostiveMessages = 0;
	private static List<String> positiveTweetWords = new ArrayList<>();
		
	public User(String userId, TwitterTree tree) {
			this.uniqueUserId = userId;
			this.following = new ArrayList<>();
			this.followers = new ArrayList<>();
			this.newsFeed = new ArrayList<>();
			numberOfUsers++;
			tree.add(this);
			System.out.println("Added a new User: " + userId);
	}	
	
	@Override
	public String getId(Component cmp) {
		return uniqueUserId;
	}
	
	static public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public String getMessage() { 
			return message; 
	} 
	 
	public void tweetMessage(String message) { 
	 		this.message = message; 
	 		this.newsFeed.add(message);
	 		notifyObservers(); 
	 		totalNumberMessages++;
	 		System.out.println(message);
	}
	
	public static int getTotalNumberMessages() {
		return totalNumberMessages;
	}
	
	public static float getTotalPositivePercentageOfMessages() {
		return (float) totalNumberPostiveMessages / (float) totalNumberMessages;
	}
	
	public int getTotalNumberTweets() {
		return newsFeed.size();
	}

	@Override
	public void update(Subject subject) { 
			message = ((User) subject).getMessage(); 
			newsFeed.add(message);
			System.out.println(message) ;
	} 
	
	public void addFollower(String userId, TwitterTree tree) {
		super.attach((Observer) tree.getComponent(userId));
		this.followers.add(userId);
		System.out.println("Added " + userId + " as a follower");
	}
	
	public void addFollowing(String uniqueId) {
		this.addFollowing(uniqueId);
	}

	public void printNewsFeed() {
		for (String s : newsFeed) { 
			System.out.println(s); 
		}
	}	
	
	public boolean isTweetPositive(String tweet) {
		String delims = "[ ]+";
		String[] tokens = tweet.split(delims);
		for (int i = 0; i < tokens.length; i++) {
			if(positiveTweetWords.contains(tokens[i])) {
				totalNumberPostiveMessages++;
				return true;
			}
		}
		return false;				
	}
	
	// following is quick test approach - would use a database for actual application
	public static void initPositiveTweetWords () {	
			positiveTweetWords.add("good");
			positiveTweetWords.add("great");
			positiveTweetWords.add("fantastic");
			positiveTweetWords.add("super");
			positiveTweetWords.add("cool");
			positiveTweetWords.add("positively");
			positiveTweetWords.add("incredible");
			positiveTweetWords.add("outstanding");
	}


	@Override
	public void add(Component cmp) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Accept(Visitor visitor) {
		visitor.visit(this);		
	}
		
}

