package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class ViewProfileInfoServlet
 */
@WebServlet("/ViewProfileInfoServlet")
public class ViewProfileInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileInfoServlet() {
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
		UserDao ud = new UserDao();
		User me = ud.getUserIfItExists(username);
		PrintWriter out = response.getWriter();
		out.println("<br><br> <b>Profile of " + me.getUsername() + "</b><br>");
		out.print("<br> Age: " + me.getAge() + "<br>");
		out.print("<br> Location: " + me.getLocation() + "<br>");
		out.print("<br> Occupation: " + me.getOccupation() + "<br><br>");
	}

}
