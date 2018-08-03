package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;

/**
 * Servlet implementation class ViewFlaggedTopicsServlet
 */
@WebServlet("/ViewFlaggedTopicsServlet")
public class ViewFlaggedTopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFlaggedTopicsServlet() {
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
		TopicDao td = new TopicDao();
		List<Topic> topics = td.getAllTopics();
		PrintWriter out = response.getWriter();
		out.print("Flagged Topics");
		for(Topic t : topics){
			if(t.getIsFlagged() == 1){
				out.println("<br>ID: " + t.getId() + " -- " + t.getContent() + "<br>");
			}
		}
		
	}

}
