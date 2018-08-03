package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Reply;

/**
 * Servlet implementation class UserViewsTheirRepliesServlet
 */
@WebServlet("/UserViewsTheirRepliesServlet")
public class UserViewsTheirRepliesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewsTheirRepliesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		ReplyDao rd = new ReplyDao();
		List<Reply> replies = rd.getAllRepliesByUsername(username);
		PrintWriter out = response.getWriter();
		for(Reply r : replies){
			out.print("<br>" + r.getContent() + "<br>");
		}
	}

}
