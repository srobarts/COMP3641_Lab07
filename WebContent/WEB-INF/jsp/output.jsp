<jsp:include page="header.jsp"></jsp:include>

<%@ page errorPage="/WEB-INF/jsp/errorPage.jsp" %>
<%@ taglib uri="/WEB-INF/lab07_taglib.tld" prefix="lab07" %>

<div id="content">
	<h1>Query Results</h1>
	<br />
	<p>Query: ${db.queryString}</p>
	
	<div id="tablecontent">
		<!--  output headers  -->
		<lab07:headertags headerNames='<%= session.getAttribute("headerNames") %>' backgroundColor="tan"></lab07:headertags>
		<lab07:rowtags rowData='<%= session.getAttribute("rowData") %>' evenRowColor="tan" oddRowColor="white"></lab07:rowtags>
		${db.cleanUp()}
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>