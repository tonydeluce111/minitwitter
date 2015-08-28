package us.deluce.minitwitter;

import java.util.Hashtable;

public class UserGroup implements Component, Visitable {
	
	private String userGroupId; 
	private Hashtable<Component, String> group;
 	private static int groupCount = 0; 
 	
 	public UserGroup(String userGroupId) {
 		this.userGroupId = userGroupId;
 		this.group = new Hashtable<Component, String>();
 		groupCount++;		
		System.out.println("Added a new Group: " + userGroupId);
 	}
 	
 	public static int getGroupCount() {
 		return groupCount;
 	}

	@Override
	public void add(Component cmp) {
		group.put(cmp, this.userGroupId);
		
	}

	@Override
	public String getId(Component cmp) {
		return userGroupId;
	}

	@Override
	public void Accept(Visitor visitor) {
		visitor.visit(this);		
	}

}
