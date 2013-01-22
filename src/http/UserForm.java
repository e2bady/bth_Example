package http;

import java.extensions.web.bth.BasicFormTableLayout;
import java.extensions.web.bth.HtmlGenerator;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dba.User;

/**
 * Servlet implementation class UserForm
 */
@WebServlet("/UserForm")
public class UserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HtmlGenerator<User> generator = new HtmlGenerator<User>();
	User u;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserForm() {
        super();
        u = new User();
		u.setName("SomeName");
		u.setSomeAtt("SomeAttr");
		u.setLastLogin(new Date());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html = generator.generate("UserForm", u, new BasicFormTableLayout()).toString();
		
		System.err.println(html);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(html);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(String key : request.getParameterMap().keySet())
			System.err.println(key + " " + request.getParameterMap().get(key)[0]);
		u = generator.parse(request.getParameterMap());
		System.err.println(u);
		response.sendRedirect("UserForm");
	}
}
