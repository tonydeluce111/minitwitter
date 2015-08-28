package us.deluce.minitwitter;

public class NumberOfGroupsVisitor implements Visitor {
	
	private int numberOfGroups = 0;
	
	@Override
	public void visit(User usr) {
		// not used		
	}

	public int getNumberOfGroups() {
		return numberOfGroups;
	}
	
	@Override
	public void visit(UserGroup usrGroup) {
		numberOfGroups++;	
	}

}
