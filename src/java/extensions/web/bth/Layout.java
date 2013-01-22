package java.extensions.web.bth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ecs.ConcreteElement;

public abstract class Layout {
	protected static Map<Class<?>, TypeMapping> layoutmap = new HashMap<Class<?>, TypeMapping>();
	static {
		layoutmap.put(Boolean.class, new TypeMapping("checkbox_", "checkbox"));
		layoutmap.put(Date.class, new TypeMapping("datepicker_", "text"));
	}
	
	protected Map<String, TypeMapping> userMappings;
	
	public abstract ConcreteElement layout(String actionPath, List<Map<String, Object>> propertyValue);
	
	protected String toString(Object obj) {
		if(obj != null) {
			if(obj instanceof Date)
			{
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
				return df.format(obj);
			}
			return obj.toString();
		}
		else 
			return null;
	}
	
	public Layout(Map<String, TypeMapping> userMappings) {
		this.userMappings = userMappings;
		this.userMappings.put("ClassName", new TypeMapping("ClassName", "hidden"));
	}
	
	protected TypeMapping getTypeMapping(String key, Object obj) {
		TypeMapping type = null;
		if(this.userMappings.containsKey(key)) {
			type = this.userMappings.get(key);
		} else if(obj != null && BasicFormTableLayout.layoutmap.containsKey(obj.getClass())) {
			type = BasicFormTableLayout.layoutmap.get(obj.getClass());
		} else {
			type = new TypeMapping("", "text");
		}
		return type;
	}
	
	protected Iterable<String> getOrderedKeySet(Map<String, Object> listObject) {
		return listObject.keySet();
	}
	
	protected String getName(String key) {
		return key;
	}
}
