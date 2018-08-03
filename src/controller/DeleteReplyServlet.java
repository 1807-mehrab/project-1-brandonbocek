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
 * Servlet implementation class DeleteReplyServlet
 */
@WebServlet("/DeleteReplyServlet")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idOfReplyToDelete");
		ReplyDao rd = new ReplyDao();
		rd.deleteReplyById(id);
		List<Reply> replies = rd.getAllReplies();
		PrintWriter out = response.getWriter();
		for(Reply r: replies){
				out.println("<br>" + r.getId() +": " + r.getContent() + "<br>");
		}
		out.print("<br>");
	}

}
