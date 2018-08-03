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
 * Servlet implementation class EditReplyServlet
 */
@WebServlet("/EditReplyServlet")
public class EditReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idToEdit = request.getParameter("idNumOfReplyToEdit");
		String newContent = request.getParameter("newContentOfEditedReply");
		System.out.println("Edited topic new content is: " + newContent);
		ReplyDao rd = new ReplyDao();
		rd.editReplyById(idToEdit, newContent);
		List<Reply> replies = rd.getAllReplies();
		PrintWriter out = response.getWriter();
		out.print("<br> Content updated <br>");
		for(Reply r : replies){
			if(r.getIsFlagged() == 1){
				out.println("<br>ID: " + r.getId() + " -- " + r.getContent() + "<br>");
			}
		}
		
	}

}
