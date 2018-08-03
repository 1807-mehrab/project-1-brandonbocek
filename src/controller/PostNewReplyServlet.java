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
 * Servlet implementation class PostNewReplyServlet
 */
@WebServlet("/PostNewReplyServlet")
public class PostNewReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostNewReplyServlet() {
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
		//System.out.println("In the reply servlet");
		String originalTopicId = request.getParameter("originalTopicId");
		String userReplyEntry = request.getParameter("userReplyEntry");
		String userThatMightReply = request.getParameter("userThatMightReply");
		//System.out.println("Receive parameters");
		ReplyDao rd = new ReplyDao();
		rd.insertNewReply(originalTopicId, userThatMightReply, userReplyEntry);
		//System.out.println("Inserted the reply");
		TopicDao td = new TopicDao();
		String topicContent = td.getTopicContentById(originalTopicId);
		//System.out.println("Got the topic again to show it");
		List<Reply> replies = rd.getAllRepliesByTopicId(originalTopicId);
		//System.out.println("Gathered all of the replies");
		PrintWriter out = response.getWriter();
		out.print("<br><b>" + topicContent + "</b>" + "<br>");
		if(!topicContent.equals("No topic found with that id")){
			if(replies.isEmpty()){
				out.print("Be the first to comment on the topic<br><br>");
			}else{
				for(Reply r: replies){
					out.print("<br><br>Posted by " + r.getPosterUsername() + "<br>id-" + r.getId() + ": " + r.getContent());
				}
			}
		}
	}

}
