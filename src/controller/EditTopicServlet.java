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
 * Servlet implementation class EditTopicServlet
 */
@WebServlet("/EditTopicServlet")
public class EditTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idToEdit = request.getParameter("idNumOfTopicToEdit");
		String newContent = request.getParameter("newContentOfEditedTopic");
		System.out.println(newContent);
		TopicDao td = new TopicDao();
		td.editTopicById(idToEdit, newContent);
		List<Topic> topics = td.getAllTopics();
		PrintWriter out = response.getWriter();
		out.print("<br> Content updated <br>");
		for(Topic t : topics){
			if(t.getIsFlagged() == 1){
				out.println("<br>ID: " + t.getId() + " -- " + t.getContent() + "<br>");
			}
		}
	}

}
