package dba;

import java.util.HashMap;
import java.util.Map;

public class Backend {
	public static void sendMail(Mail m) {
		//Put into mail-queue
	}
	
	public static Map<String, String> getDrafts() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("vorlage1", "blablabla");
		map.put("vorlage2", "blablablablablabla");
		map.put("vorlage3", "blablablablablablablablabla");
		map.put("vorlage4", "blablablablablablablablablablablabla");
		return map;
	}
	
	public static User[] getUsers(String filter) {
		return null;
	}
	
	public static void updateUser(int id, User u) {
		
	}
	
	public static void createUser(User u) {
		
	}
}
