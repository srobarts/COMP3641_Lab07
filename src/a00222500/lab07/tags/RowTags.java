package a00222500.lab07.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class RowTags extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Vector rowData;
	private int count = 0;
	private int fieldCount = 0;
	
	@SuppressWarnings("rawtypes")
	public void setRowData(Object rowData) {
	      this.rowData = (Vector) rowData;
	}
	
	public int doStartTag()
	{		
		try {
			JspWriter out = pageContext.getOut();
			//iterate through headers
			@SuppressWarnings("rawtypes")
			Iterator rows = rowData.iterator();
			
			while (rows.hasNext()) {
				if (count % 2 == 0) {
					out.print("<tr bgcolor=\"#c3f3c3\">");
				} else {
					out.print("<tr bgcolor=\"#FFFFF\">");
				}
				@SuppressWarnings("rawtypes")
				Vector singleRow = (Vector)rows.next();
				@SuppressWarnings("rawtypes")
				Iterator fields = singleRow.iterator();
				while (fields.hasNext()) {
					String field = (String)fields.next();
					out.print("<td>" + field + "</td>");
					fieldCount++;
				}
				
			}
		} catch (IOException ioe) {
			System.out.println("Error in tag: " + ioe);
		}
		return(EVAL_BODY_INCLUDE);
	}

}
