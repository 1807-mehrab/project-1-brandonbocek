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
 * Servlet implementation class ViewTopicDetailsServlet
 */
@WebServlet("/ViewTopicDetailsServlet")
public class ViewTopicDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTopicDetailsServlet() {
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
		
		String topicId = request.getParameter("topicId");
		String userThatMightReply = request.getParameter("userThatMightReply");
		ReplyDao rd = new ReplyDao();
		List<Reply> replies = rd.getAllRepliesByTopicId(topicId);
		TopicDao td = new TopicDao();
		String topicContent = td.getTopicContentById(topicId);
		PrintWriter out = response.getWriter();
		out.print("<b>" + topicContent + "</b>" + "<br><br>");
		if(!topicContent.equals("No topic found with that id")){
			if(replies.isEmpty()){
				out.print("Be the first to comment on the topic<br><br>");
			}else{
				for(Reply r: replies){
					out.print("Posted by " + r.getPosterUsername() + "<br>id-" + r.getId()+ ": " + r.getContent() + "<br><br>");
				}
			}
		}
		
		
	}

}
