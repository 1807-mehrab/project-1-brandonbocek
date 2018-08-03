package beans;

public class User {

	public User(int id, String username, String userPassword) {
		this.setId(id);
		this.username = username;
		this.userPassword = userPassword;
	}
	
	public User(int id, String username, String userPassword, int age, String location, String job) {
		this.setId(id);
		this.username = username;
		this.userPassword = userPassword;
		this.age=age;
		this.location=location;
		this.occupation=job;
	}
	
	private String username;
	private String userPassword;
	private int id;
	private int age;
	private String location;
	private String occupation;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	
	
}
