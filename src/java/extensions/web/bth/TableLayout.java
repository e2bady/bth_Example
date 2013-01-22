package java.extensions.web.bth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ecs.ConcreteElement;
import org.apache.ecs.html.A;
import org.apache.ecs.html.Input;
import org.apache.ecs.html.TD;
import org.apache.ecs.html.TH;
import org.apache.ecs.html.TR;
import org.apache.ecs.html.Table;

public class TableLayout extends OrderedLayout {
	public TableLayout() {
		this(new HashMap<String, TypeMapping>());	
	}
	
	public TableLayout(Map<String, TypeMapping> userMappings) {
		super(userMappings);
		super.userMappings.put("Details", new TypeMapping("link_", "Details"));
		super.userMappings.put("ClassName", new TypeMapping("hidden_", "hidden"));
	}

	@Override
	public ConcreteElement layout(String actionPath,
			List<Map<String, Object>> propertyValue) {
		if(propertyValue.size() == 0) return null;
		
		Table table = new Table();
		table.setBorder(1);
		
		TR th = createTableHeader(propertyValue);
		table.addElement(th);
		
		for(Map<String, Object> listObject : propertyValue) {
			TR curr = new TR();
			for(String key : super.getOrderedKeySet(listObject)) {
				Object obj = listObject.get(key);
				System.err.println(obj);
				TypeMapping type = getTypeMapping(key, obj);
				TD td = null;
				
				if(type.getType().equals("Details")) {
					td = new TD();
					td.addElement(new A(super.toString(obj), "Details"));
				} else if(type.getType().equals("hidden")) {
					Input input = new Input();
					input.setType(type.getType());
					input.setValue(super.toString(obj));
					input.setName(key);
					input.setID(type.getId() + key);
					table.addElement(input);
				}
				else //if(type.getType().equals("String"))
					 td = new TD(super.toString(obj));
				curr.addElement(td);
				System.err.println(td);
			}
			table.addElement(curr);
		}
		return table;
	}

	private TR createTableHeader(List<Map<String, Object>> propertyValue) {
		TR th = new TR();
		for(String header : super.getOrderedKeySet(propertyValue.get(0)))
			if(!header.equals("ClassName"))
				th.addElementToRegistry(new TH(super.getName(header)));
		return th;
	}

}
