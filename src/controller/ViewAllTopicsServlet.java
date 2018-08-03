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
 * Servlet implementation class ViewAllTopicsServlet
 */
@WebServlet("/ViewAllTopicsServlet")
public class ViewAllTopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTopicsServlet() {
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
		out.println("<br><br> Message Board Topics");
		for(Topic t: topics){
			if(t.getContent() != null)
				out.print("<br><br>id: " + t.getId() + "<br><b>" + t.getContent() + "</b><br> <&nbsp>Posted by " + t.getPosterUsername());
				//out.println("<br><form id='userViewsAllTopicsView'><input type='hidden' name='topicId' value='"+ t.getId() +"'><input type='button' value='" + t.getContent() + "' id='getTopicDetailsBtn'><br></form>");		
		}
	}

}
