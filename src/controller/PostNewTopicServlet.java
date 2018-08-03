package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostNewTopicServlet
 */
@WebServlet("/PostNewTopicServlet")
public class PostNewTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostNewTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		String newTopicPostText = request.getParameter("newTopicPostText");
		String userWhoPostedTopic = request.getParameter("userWhoPostedTopic");
		
		System.out.println("New topic post text = " + newTopicPostText);
		
		TopicDao td = new TopicDao();
		PrintWriter out = response.getWriter();
		try{
			if(newTopicPostText.length() > 2){
				td.insertNewTopic(userWhoPostedTopic, newTopicPostText);
				out.print("Topic was posted");
			} else {
				out.print("Nothing was posted due to missing info");
			}
		}catch(Exception exc){
			out.print("Nothing was posted due to missing info");
		}
	}

}
