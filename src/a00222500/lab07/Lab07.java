package a00222500.lab07;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import a00222500.lab07.DatabaseBean;

/**
 * Servlet implementation class Lab07
 */
@WebServlet("/Lab07")
public class Lab07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseBean db;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lab07() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * servletInit() retrieves database information from web.xml and connects to database
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String url;
		String driver;
		String username;
		String password;
		
		db = new DatabaseBean();
		
		config = getServletConfig();
		driver = config.getInitParameter("driver");
		url = config.getInitParameter("url");
		username = config.getInitParameter("username");
		password = config.getInitParameter("password");
		
		//connect to database
		db.connect(url, username, password, driver);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String requestedAction = request.getParameter("action");
		if(requestedAction.equals("query")) {
			//query is being sent - send to database
			String queryString = request.getParameter("query");
			
			db.setQueryString(queryString);
			@SuppressWarnings("rawtypes")
			Vector tableData = db.runQuery();
			/*@SuppressWarnings("rawtypes")
			Iterator rows = tableData.iterator();*/
			
			//display headers
			@SuppressWarnings("rawtypes")
			Vector headerNames = null;
			try {
				headerNames = db.generateMetaData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/*@SuppressWarnings("rawtypes")
			Iterator headers = headerNames.iterator();*/
			
			session.setAttribute("db", this.db);
			session.setAttribute("headerNames", headerNames);
			session.setAttribute("rowData", tableData);
			
			//send results to results page
			String url2 = "/WEB-INF/jsp/output.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url2);
			dispatcher.forward(request, response);	
			
			//close database connection
			//db.cleanUp();	
			
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
