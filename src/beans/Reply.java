package beans;

public class Reply {

	private int id;
	private String posterUsername;
	private String content;
	private int original_comment_id;
	private int isFlagged;
	
	public Reply(int id, int original_comment_id,  String posterUsername, String content, int isFlagged) {
		this.id=id;
		this.original_comment_id=original_comment_id;
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

	public String getPosterUsername() {
		return posterUsername;
	}

	public void setPosterUsername(String posterUsername) {
		this.posterUsername = posterUsername;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getOriginal_comment_id() {
		return original_comment_id;
	}

	public void setOriginal_comment_id(int original_comment_id) {
		this.original_comment_id = original_comment_id;
	}

	public int getIsFlagged() {
		return isFlagged;
	}

	public void setIsFlagged(int isFlagged) {
		this.isFlagged = isFlagged;
	}

	
}
