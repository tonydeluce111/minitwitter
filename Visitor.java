package us.deluce.minitwitter;

public interface Visitor {
	
	public void visit(UserGroup usrGroup);
	
	public void visit(User usr);

}
