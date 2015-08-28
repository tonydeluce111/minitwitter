package us.deluce.minitwitter;

public class MiniTwitter {
	
	private static AdminUI instance = null;  
	 
    private MiniTwitter() {}
	 
    public static AdminUI getInstance() { 
 		if (instance == null) { 
 			instance = new AdminUI(); 
 		} 
 		return instance; 
 	} 

}

