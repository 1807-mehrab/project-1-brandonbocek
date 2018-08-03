package beans;

public class Topic {
	private int id;
	private String posterUsername;
	private String content;
	private int isFlagged;
	
	public Topic(int id, String posterUsername, String content){
		this.id=id;
		this.posterUsername=posterUsername;
		this.content=content;
	}
	
	public Topic(int id, String posterUsername, String content, int isFlagged){
		this.id=id;
		this.posterUsername=posterUsername;
		this.content=content;
		this.isFlagged=isFlagged;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPosterUsername() {
		return posterUsername;
	}

	public void setPosterUsername(String posterUsername) {
		this.posterUsername = posterUsername;
	}

	public int getIsFlagged() {
		return isFlagged;
	}

	public void setIsFlagged(int isFlagged) {
		this.isFlagged = isFlagged;
	}
	
}
