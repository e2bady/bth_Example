package java.extensions.web.bth;

import java.extensions.jx.beanutils.BeanAccessException;
import java.extensions.jx.beanutils.BeanUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ecs.ConcreteElement;


public class HtmlGenerator<E> extends AbstractHtmlGenerator<E>{
	@SuppressWarnings("unchecked")
	@Override
	protected ConcreteElement generateHtml(String actionPath, E object, Layout layout) {
		List<Object> lst;
		if(object instanceof List<?>)
			lst = (List<Object>) object;
		else 
		{
			lst = new ArrayList<Object>();
			lst.add(object);
		}
		List<Map<String, Object>> wrapper = new ArrayList<Map<String, Object>>();
		for(Object o : lst) {
			Map<String, Object> propertyValue = new LinkedHashMap<String, Object>();
			for(String str : super.getProperties(o)) {
				try {
					propertyValue.put(str, BeanUtils.getPropertyValue(o, str));
				} catch (BeanAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			propertyValue.put("ClassName", o.getClass().getName());
			propertyValue.put("Details", super.parseActionPath(actionPath, o));
			
			wrapper.add(propertyValue);
		}
		return layout.layout(actionPath, wrapper);
	}
}
