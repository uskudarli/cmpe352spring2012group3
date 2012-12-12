package Tables;

public class ForumTopicTable {
	private int id;
	private int topicId;
	private String title;
	private int repliesCount;
	private int viewsCount;
	private int creationTime;
	private int userId;
	private int lastPostId;
	
	public ForumTopicTable(int id, int topicId, String title, int repliesCount,
			int viewsCount, int creationTime, int userId, int lastPostId) {
		this.id = id;
		this.topicId = topicId;
		this.title = title;
		this.repliesCount = repliesCount;
		this.viewsCount = viewsCount;
		this.creationTime = creationTime;
		this.userId = userId;
		this.lastPostId = lastPostId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRepliesCount() {
		return repliesCount;
	}

	public void setRepliesCount(int repliesCount) {
		this.repliesCount = repliesCount;
	}

	public int getViewsCount() {
		return viewsCount;
	}

	public void setViewsCount(int viewsCount) {
		this.viewsCount = viewsCount;
	}

	public int getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(int creationTime) {
		this.creationTime = creationTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLastPostId() {
		return lastPostId;
	}

	public void setLastPostId(int lastPostId) {
		this.lastPostId = lastPostId;
	}
	
	
}
