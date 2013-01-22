package http;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.extensions.web.bth.HtmlGenerator;
import java.extensions.web.bth.OrderedLayout;
import java.extensions.web.bth.TableLayout;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dba.User;

/**
 * Servlet implementation class UserTable
 */
@WebServlet("/UserTable")
public class UserTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> user = new ArrayList<User>();
		user.add(new User("abc","abc", new Date()));
		user.add(new User("def","def",new Date()));
		user.add(new User("qwe","qwe",new Date()));
		user.add(new User("asd","asd",new Date()));
		user.add(new User("yxc","yxc",new Date()));
		user.add(new User("rtz","rtz",new Date()));
		user.add(new User("fgh","fgh",new Date()));
		
		HtmlGenerator<List<User>> tg = new HtmlGenerator<List<User>>();
		OrderedLayout layout = new TableLayout();
		layout.setOrder(new String[]{"name", "someAtt", "lastLogin"});
		Map<String, String> header = new HashMap<String, String>();
		header.put("name", "Name");
		header.put("someAtt", "Vorname");
		header.put("lastLogin", "zuletzt eingeloggt");
		layout.setAliases(header);
		String str = tg.generate("UserForm.jsp?userid=${name}", user, layout).toString();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
