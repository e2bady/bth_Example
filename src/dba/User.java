package dba;

import java.util.Date;

public class User {
	private String name;
	private String someAtt;
	private Date lastLogin;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		super();
	}
	public User(String name, String someAtt, Date lastLogin) {
		super();
		this.name = name;
		this.someAtt = someAtt;
		this.lastLogin = lastLogin;
	}
	public String getSomeAtt() {
		return someAtt;
	}
	public void setSomeAtt(String someAtt) {
		this.someAtt = someAtt;
	}
	
	@Override
	public String toString() {
		return String.format("User [name=%s, someAtt=%s, lastLogin=%s]", name, someAtt, lastLogin);
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	} 
}
