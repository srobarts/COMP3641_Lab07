<jsp:include page="header.jsp"></jsp:include>

<%@ page errorPage="/WEB-INF/jsp/errorPage.jsp" %>
<%@ taglib uri="/WEB-INF/lab07_taglib.tld" prefix="lab07" %>

<div id="content">
	<h1>Query Results:</h1>
	<br />
	<em>Your Query: ${db.queryString}</em>
	<br />
	<h3><a href="./index.jsp">Query Again</a></h3>
	
	<div id="tablecontent">
		<!--  output headers  -->
		<lab07:headertags headerNames='<%= session.getAttribute("headerNames") %>' backgroundColor="tan"></lab07:headertags>
		<lab07:rowtags rowData='<%= session.getAttribute("rowData") %>' evenRowColor="tan" oddRowColor="white"></lab07:rowtags>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>