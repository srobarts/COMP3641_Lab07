<jsp:include page="header.jsp"></jsp:include>

<%@ page errorPage="/errorPage.jsp" %>
<%@ taglib uri="/WEB-INF/lab07_taglib.tld" prefix="lab07" %>

<div id="content">
	<h1>Query Results</h1>
	<br />
	
	<div id="tablecontent">
		<!--  custom tags here  -->
		<lab07:headertags />
	</div>

</div>



<jsp:include page="footer.jsp"></jsp:include>