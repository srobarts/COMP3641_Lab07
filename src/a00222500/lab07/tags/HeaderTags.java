package a00222500.lab07.tags;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class HeaderTags extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	
	//get Vector object out of session and parse out
	
	
	public int doStartTag()
	{		
		String field = "STUFF";
		try {
			JspWriter out = pageContext.getOut();
			out.print("<table>");
			out.print("<td>" + field + "</td>");
			out.print("</table>");
		} catch (IOException ioe) {
			System.out.println("Error in tag: " + ioe);
		}
		return(EVAL_BODY_INCLUDE);
	}
	

}
