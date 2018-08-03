package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import util.ConnectionUtil;

public class UserDao {
	
	List<User> users;
	
	public List<User> getAllUsers() {
		PreparedStatement ps = null;
		User u = null;
		users = new ArrayList<User>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM MSG_USERS";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String userPassword = rs.getString("USERPASSWORD");
				
				
				u = new User(id, username, userPassword);
				users.add(u);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return users;
	}
	
	public void insertNewUser(){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO MSG_USERS (USER_ID, USERNAME, USERPASSWORD) VALUES(USER_ID_SEQ.NEXTVAL, 'annaB4n4n4', 'whoa')";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public User getUserIfItExists(String name, String password){
		PreparedStatement ps = null;
		User u = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM MSG_USERS WHERE USERNAME='" + name + "' AND USERPASSWORD='" + password +"'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String userPassword = rs.getString("USERPASSWORD");
				
				
				u = new User(id, username, userPassword);
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return u;
	}
	
	public User getUserIfItExists(String name){
		PreparedStatement ps = null;
		User u = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM MSG_USERS WHERE USERNAME='" + name + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String userPassword = rs.getString("USERPASSWORD");
				int userAge = rs.getInt("AGE");
				String userCity = rs.getString("RESIDENCY_LOCATION");
				String userJob = rs.getString("OCCUPATION");
				
				u = new User(id, username, userPassword, userAge, userCity, userJob);
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return u;
	}
	
	public void updateUser(String username, String age, String location, String job){
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE MSG_USERS SET AGE="+age+", RESIDENCY_LOCATION='"
					+location+"', OCCUPATION='" + job + "' WHERE USERNAME='"+ username + "'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
