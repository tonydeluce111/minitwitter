package us.deluce.minitwitter;

public class NumberOfUsersVisitor implements Visitor {
	
	private int numberOfUsers = 0;
	
	@Override
	public void visit(User usr) {
		numberOfUsers++;
		
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}
	
	@Override
	public void visit(UserGroup usrGroup) {
		// Not used 		
	}



}
