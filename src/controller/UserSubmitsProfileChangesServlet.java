package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSubmitsProfileChangesServlet
 */
@WebServlet("/UserSubmitsProfileChangesServlet")
public class UserSubmitsProfileChangesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSubmitsProfileChangesServlet() {
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
		String age = request.getParameter("userNewAge");
		String location = request.getParameter("userNewLocation");
		String job = request.getParameter("userNewOccupation");
		UserDao ud = new UserDao();
		ud.updateUser(username, age, location, job);
		PrintWriter out = response.getWriter();
		out.println("Profile Updated");
	}

}
