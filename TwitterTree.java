package us.deluce.minitwitter;

import java.util.Hashtable;

public class TwitterTree implements Component, Visitable {
	
	private static Hashtable<String, Component> twitterTree;
	
	public TwitterTree() {
		twitterTree = new Hashtable<String, Component>();		
	}
	
	@Override
	public void add(Component cmp) {	
		twitterTree.put(cmp.getId(cmp), cmp);
	}
	
	@Override
	public String getId(Component cmp) {
		return null;
	}

	@Override
	public void Accept(Visitor visitor) {
		visitor.equals(this);		
	}
	
	public Component getComponent(String Id) {
		return this.getComponent(Id);
		
	}


}
