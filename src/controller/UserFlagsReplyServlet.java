package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserFlagsReplyServlet
 */
@WebServlet("/UserFlagsReplyServlet")
public class UserFlagsReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFlagsReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In the flag reply servlet");
		
		String id = request.getParameter("userFlagReplyEntry");
		System.out.println("Reply id to flag is " + id);
		ReplyDao rd = new ReplyDao();
		rd.flagReplyById(id);
		PrintWriter out = response.getWriter();
		out.println("Reply of id " + id + " was flagged");
	}

}
