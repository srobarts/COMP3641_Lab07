package a00222500.lab07.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * HeaderTags is a custom tag designed to take in a Vector object
 * and parse through it displaying all of the header values
 * of a given query
 * 
 * @author srobarts
 *
 */
public class HeaderTags extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Vector headerNames;
	
	@SuppressWarnings("rawtypes")
	public void setHeaderNames(Object headerNames) {
	      this.headerNames = (Vector) headerNames;
	}
	
	public int doStartTag()
	{		
		try {
			JspWriter out = pageContext.getOut();
			//iterate through headers
			@SuppressWarnings("rawtypes")
			Iterator headers = headerNames.iterator();
			out.print("<tr>");
			while (headers.hasNext()) {
				String title = (String)headers.next();
				out.print("<td>" + title + "</td>");
			}
			out.print("</tr>");
		} catch (IOException ioe) {
			System.out.println("Error in tag: " + ioe);
		}
		return(EVAL_BODY_INCLUDE);
	}
	

}
