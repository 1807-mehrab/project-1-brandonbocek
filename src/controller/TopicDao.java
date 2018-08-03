package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Topic;
import util.ConnectionUtil;

public class TopicDao {

	List<Topic> topics;
	
	public List<Topic> getAllTopics() {
		PreparedStatement ps = null;
		Topic t = null;
		topics = new ArrayList<Topic>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM TOPICS";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("TOPIC_ID");
				String username = rs.getString("POSTED_BY");
				String content = rs.getString("TOPIC_CONTENT");
				int isFlagged = rs.getInt("IS_FLAGGED");
				
				t = new Topic(id, username, content, isFlagged);
				topics.add(t);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return topics;
	}
	
	public void insertNewTopic(String username, String content){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO TOPICS (TOPIC_ID, POSTED_BY, TOPIC_CONTENT) VALUES(TOPIC_ID_SEQ.NEXTVAL, '"+ username +"', '" + content + "')";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public Topic getTopicIfItExists(String content){
		PreparedStatement ps = null;
		Topic t = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM TOPICS WHERE TOPIC_CONTENT='" + content + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("TOPIC_ID");
				String username = rs.getString("POSTED_BY");
				String foundContent = rs.getString("TOPIC_CONTENT");
				
				
				t = new Topic(id, username, foundContent);
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return t;
	}
	
	public void deleteTopicById(String id){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM TOPICS WHERE TOPIC_ID='" + id + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getTopicContentById(String id){
		PreparedStatement ps = null;
		String foundContent = "No topic found with that id";
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM TOPICS WHERE TOPIC_ID='" + id + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				foundContent = rs.getString("TOPIC_CONTENT");
				
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return foundContent;
	}
	
	public void flagTopicById(String idToFlag){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE TOPICS SET IS_FLAGGED=1 WHERE TOPIC_ID="+idToFlag;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void editTopicById(String id, String newContent){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE TOPICS SET TOPIC_CONTENT='" + newContent + "' WHERE TOPIC_ID=" + id;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
