package java.extensions.web.bth;

import java.extensions.jx.beanutils.BeanAccessException;
import java.extensions.jx.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class AbstractGenerator<E> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<String> getProperties(Object object) {
		try {
			Map map = org.apache.commons.beanutils.BeanUtils.describe(object);
			Object[] obj = map.keySet().toArray(new Object[map.keySet().size()]);
			List<String> strs = new ArrayList<String>(obj.length);
			for(Object s : obj) {
				if(!((String)s).equals("class"))
					strs.add((String)s);
			}
			return strs;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public E parse(Map<String, String[]> parameters) {
		E bean = null;
		try {
			bean = BeanUtils.instantiateBean(parameters);
			BeanUtils.populate(bean, parameters);
		} catch (BeanAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
}
