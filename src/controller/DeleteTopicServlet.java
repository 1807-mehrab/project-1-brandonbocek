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
 * Servlet implementation class DeleteTopicServlet
 */
@WebServlet("/DeleteTopicServlet")
public class DeleteTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idOfTopicToDelete");
		TopicDao td = new TopicDao();
		td.deleteTopicById(id);
		ReplyDao rd = new ReplyDao();
		rd.deleteReplyByTopicId(id);
		List<Topic> topics = td.getAllTopics();
		PrintWriter out = response.getWriter();
		for(Topic t: topics){
				out.println("<br>" + t.getId() +": " + t.getContent() + "<br>");
		}
		out.print("<br>");
	}

}
