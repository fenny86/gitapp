package bean;

public class Post {

	private Integer postId;
	private String postTitle;
	private String postDate;
	private String postContent;	
	private String postLike;	
	private String postDislike;	
	private String postComment;
	
	public Post() {
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postDate=" + postDate + ", postContent="
				+ postContent + ", postLike=" + postLike + ", postDislike=" + postDislike + ", postComment="
				+ postComment + "]";
	}

	public Post(Integer postId, String postTitle, String postDate, String postContent, String postLike,
			String postDislike, String postComment) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.postContent = postContent;
		this.postLike = postLike;
		this.postDislike = postDislike;
		this.postComment = postComment;
	}

	public Integer getpostId() {
		return postId;
	}

	public void setpostId(Integer postId) {
		this.postId = postId;
	}

	public String getpostTitle() {
		return postTitle;
	}

	public void setpostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getpostDate() {
		return postDate;
	}

	public void setpostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getpostContent() {
		return postContent;
	}

	public void setpostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getpostLike() {
		return postLike;
	}

	public void setpostLike(String postLike) {
		this.postLike = postLike;
	}

	public String getpostDislike() {
		return postDislike;
	}

	public void setpostDislike(String postDislike) {
		this.postDislike = postDislike;
	}

	public String getpostComment() {
		return postComment;
	}

	public void setpostComment(String postComment) {
		this.postComment = postComment;
	}
	


}