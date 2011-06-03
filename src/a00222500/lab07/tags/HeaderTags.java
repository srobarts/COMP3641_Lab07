package a00222500.lab07.tags;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.swing.text.html.HTMLDocument.Iterator;

public class HeaderTags extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<LineItem> lineItems;
	private Iterator iterator;
	private LineItem item;
	
	public int doStartTag()
	{
		Vector headers (String) pageContext.findAttribute("headers");
		lineItems = headers.getItems();
		if(lineItems.size() <= 0) {
			return SKIP_BODY;
		} else {
			return EVAL_BODY_BUFFERED;
		}
	}
	
	public void doInitBody() throws JspException
	{
		iterator = lineItems.iterator();
		if(iterator.hasNext())
		{
			item = (LineItem)iterator.next();
			this.setItemAttributes(item);
		}
	}
	

}
