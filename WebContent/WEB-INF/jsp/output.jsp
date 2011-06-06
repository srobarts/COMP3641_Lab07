<jsp:include page="header.jsp"></jsp:include>

<%@ page errorPage="/WEB-INF/jsp/errorPage.jsp" %>
<%@ taglib uri="/WEB-INF/lab07_taglib.tld" prefix="lab07" %>

<div id="content">
	<h1>Query Results</h1>
	<br />
	<p>Query: ${db.queryString}</p>
	
	<div id="tablecontent">
		<!--  output headers  -->
		<table>
		<lab07:headertags headerNames='<%= session.getAttribute("headerNames") %>'></lab07:headertags>
		<lab07:rowtags rowData='<%= session.getAttribute("rowData") %>'></lab07:rowtags>
		</table>
	</div>

</div>
<<<<<<< HEAD
=======


>>>>>>> 88e985a6deb608877ca30a3b8dc4d9bb2806e6cb

<jsp:include page="footer.jsp"></jsp:include>