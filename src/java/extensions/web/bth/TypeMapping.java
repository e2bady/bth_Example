package java.extensions.web.bth;

public class TypeMapping {
	private String id;
	private String type;
	
	public TypeMapping(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public TypeMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
