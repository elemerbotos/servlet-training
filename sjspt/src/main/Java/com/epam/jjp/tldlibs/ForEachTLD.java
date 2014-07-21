package com.epam.jjp.tldlibs;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
// c====================3

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections4.iterators.ArrayIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForEachTLD extends SimpleTagSupport {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ForEachTLD.class);
	private Object items;
	private String var;
	private Iterator<?> iterator;
	
	public void setItems(Object items) {
		this.items = items;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		iterator = getIterator();
		if(iterator == null) {
			LOGGER.info("Item has no element in foreach cycle! ");
		} else {
			while(iterator.hasNext()) {
				JspContext context = getJspContext();
				context.setAttribute(var, iterator.next());
				getJspBody().invoke(null);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private Iterator<?> getIterator() {
		Iterator<?> result = null;
		if(items instanceof Iterable) {
			result = ((Iterable)items).iterator();
		} else if(items instanceof Object[]){
			result = new ArrayIterator((Object[])items);
		} else if(items instanceof Map) {
			result = ((Map)items).values().iterator();
		} else {
			System.out.println(items.getClass());
		}
		return result;
	}
}
