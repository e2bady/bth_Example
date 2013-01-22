package java.extensions.web.bth;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ecs.html.Form;
import org.apache.ecs.html.Input;
import org.apache.ecs.html.TD;
import org.apache.ecs.html.TR;
import org.apache.ecs.html.Table;

public class BasicFormTableLayout extends Layout {
	public BasicFormTableLayout() {
		this(new LinkedHashMap<String, TypeMapping>());
	}
	public BasicFormTableLayout(Map<String, TypeMapping> userMappings) {
		super(userMappings);
		super.userMappings.put("Details", new TypeMapping("hidden_", "hidden"));
	}
	
	@Override
	public Form layout(String actionPath, List<Map<String, Object>> propertyValue) {
		Form f = new Form();
		f.setAcceptCharset("UTF-8");
		f.setAction(actionPath);
		f.setMethod("post");
		
		Table table = new Table();
		
		for(String key : super.getOrderedKeySet(propertyValue.get(0))) {
			Object obj = propertyValue.get(0).get(key);
			TypeMapping type = getTypeMapping(key, obj);
			
			Input input = new Input();
			input.setType(type.getType());
			if(obj != null)
				input.setValue(super.toString(obj));
			input.setName(key);
			input.setID(type.getId() + key);
			
			if(!type.getType().equals("hidden")) {
				TR row = new TR();
				row.addElement(new TD(super.getName(key)));
				row.addElement(new TD(input));
				table.addElement(row);
			} else {
				f.addElement(input);
			}
		}
		
		addSubmitButton(table);
		
		f.addElement(table);
		
		return f;
	}
	
	private void addSubmitButton(Table table) {
		Input input = new Input();
		input.setType("Submit");
		input.setName("Submit");
		
		TR row = new TR();
		row.addElement(new TD(""));
		row.addElement(new TD(input));
		table.addElement(row);
	}
}
