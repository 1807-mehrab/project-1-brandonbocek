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
import beans.Topic;

/**
 * Servlet implementation class ViewFlaggedRepliesServlet
 */
@WebServlet("/ViewFlaggedRepliesServlet")
public class ViewFlaggedRepliesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFlaggedRepliesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDao rd = new ReplyDao();
		List<Reply> replies = rd.getAllReplies();
		
		PrintWriter out = response.getWriter();
		out.print("Flagged Replies");
		for(Reply r : replies){
			if(r.getIsFlagged() == 1){
				out.println("<br>ID: " + r.getId() + " -- " + r.getContent() + "<br>");
			}
		}
	}

}
