<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

<%@ page errorPage="/WEB-INF/jsp/errorPage.jsp" %>

<div id="content">
	
	<div id="stylized" class="myform">
		<form id="form" name="form" method="post" action="query_database">
			<input name="action" type="hidden" value="query" />
			<p>Input a correct SQL statement below to query the database.<br />
			Query results will be show on the following page after submission.</p>
			
			<h3>Sample Query:</h3>
			<p>SELECT * FROM beatles<br />
			SELECT * FROM beatles WHERE title LIKE '%Help%'</p>
			
			<h3>Please input your query:</h3><br />
			<input SIZE="50" name="query" id="query" />
			
			<button type="submit">Submit</button>
			<div class="spacer"></div>
		</form>
	</div>
	
</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>