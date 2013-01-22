package java.extensions.web.bth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class OrderedLayout extends Layout {
	private ArrayList<String> order = null;
	private Map<String, String> aliases;
	
	public OrderedLayout(Map<String, TypeMapping> userMappings) {
		super(userMappings);
	}
	
	@Override
	protected Iterable<String> getOrderedKeySet(Map<String, Object> listObject) {
		if(order == null) {
			this.setOrder(listObject.keySet());
		}
		return order;
	}
	
	public void setOrder(Set<String> order) {
		this.setOrder(order.toArray(new String[order.size()]));
	}
	
	public void setOrder(List<String> order) {
		this.setOrder(order.toArray(new String[order.size()]));
	}
	
	public void setOrder(String[] order) {
		this.order = new ArrayList<String>();
		for(String s : order)
			this.order.add(s);
	}
	
	public void setAliases(Map<String, String> propertyToName) {
		this.aliases = propertyToName;
	}

	@Override
	protected String getName(String key) {
		if(aliases != null && aliases.containsKey(key))
			return aliases.get(key);
		else
			return key;
	}
}
