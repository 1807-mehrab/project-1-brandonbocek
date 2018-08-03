package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Reply;
import util.ConnectionUtil;

public class ReplyDao {

	List<Reply> replies;
	
	public List<Reply> getAllReplies() {
		PreparedStatement ps = null;
		Reply r = null;
		replies = new ArrayList<Reply>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REPLIES";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int replyId = rs.getInt("REPLY_ID");
				int origCommentId = rs.getInt("ORIG_COMMENT_ID");
				String username = rs.getString("POSTED_BY");
				String content = rs.getString("REPLY_CONTENT");
				int isFlagged = rs.getInt("IS_FLAGGED");
				
				r = new Reply(replyId,origCommentId, username, content, isFlagged);
				replies.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return replies;
	}
	
	public List<Reply> getAllRepliesByTopicId(String topicId) {
		PreparedStatement ps = null;
		Reply r = null;
		replies = new ArrayList<Reply>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REPLIES WHERE ORIG_COMMENT_ID=" + topicId;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int replyId = rs.getInt("REPLY_ID");
				int origCommentId = rs.getInt("ORIG_COMMENT_ID");
				String username = rs.getString("POSTED_BY");
				String content = rs.getString("REPLY_CONTENT");
				int isFlagged = rs.getInt("IS_FLAGGED");
				
				
				r = new Reply(replyId,origCommentId, username, content, isFlagged);
				replies.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return replies;
	}
	
	public List<Reply> getAllRepliesByUsername(String username) {
		PreparedStatement ps = null;
		Reply r = null;
		replies = new ArrayList<Reply>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REPLIES WHERE POSTED_BY='" + username + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int replyId = rs.getInt("REPLY_ID");
				int origCommentId = rs.getInt("ORIG_COMMENT_ID");
				String nameOfUser = rs.getString("POSTED_BY");
				String content = rs.getString("REPLY_CONTENT");
				int isFlagged = rs.getInt("IS_FLAGGED");
				
				
				r = new Reply(replyId,origCommentId, nameOfUser, content, isFlagged);
				replies.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return replies;
	}
	
	public void insertNewReply(String topicId, String username, String content){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO REPLIES (REPLY_ID, ORIG_COMMENT_ID, POSTED_BY, REPLY_CONTENT, IS_FLAGGED) VALUES(REPLY_ID_SEQ.NEXTVAL, " + topicId + ", '"+ username +"', '" + content + "', 0)";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void deleteReplyById(String id){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM REPLIES WHERE REPLY_ID='" + id + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteReplyByTopicId(String id){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM REPLIES WHERE ORIG_COMMENT_ID='" + id + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void flagReplyById(String id){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REPLIES SET IS_FLAGGED=1 WHERE REPLY_ID=" + id;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void editReplyById(String id, String newContent){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REPLIES SET REPLY_CONTENT='" + newContent + "' WHERE REPLY_ID=" + id;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
