package java.extensions.web.bth;

import java.extensions.jx.beanutils.BeanAccessException;
import java.extensions.jx.beanutils.BeanUtils;
import java.util.ArrayList;
import java.util.List;

import org.apache.ecs.ConcreteElement;


abstract class AbstractHtmlGenerator<E> extends AbstractGenerator<E> {
	abstract protected ConcreteElement generateHtml(String actionPath, E object, Layout layout);
	
	public ConcreteElement generate(String actionPath, E object, Layout layout) {
		return this.generateHtml(actionPath, object, layout);
	}

	/**
	 * @param actionPath JSTL convention. SomeServlet?parameterName=${propertyName} -> SomeServlet?parameterName=${propertyValue}
	 */
	protected String parseActionPath(String actionPath, Object o) {
		char[] ary = actionPath.toCharArray();
		String link = "";
		int state = 0; //0 = nothing found; 1 = ${ found waiting on closetag.
		List<String> properties = new ArrayList<String>();
		
		String prop = "";
		
		for(int i=0;i<ary.length;i++) {
			if(state == 0 && ary[i] == '$' && ary[i+1] == '{') {
				state = 1;
				prop = "";
				i++;
			} else if(state == 1 && ary[i] == '}') {
				state = 0;
				link += "%s";
				properties.add(prop);
			} else if(state == 0) {
				link += ary[i];
			} else if(state == 1) {
				prop += ary[i];
			}
		}
		
		List<String> values = new ArrayList<String>();
		for(int i=0;i<properties.size();i++) {
			try {
				values.add( (BeanUtils.getPropertyValue(o, properties.get(i)).toString()));
			} catch (BeanAccessException e) {
				e.printStackTrace();
			}
		}
		return String.format(link, values);
	}
	
	
}
