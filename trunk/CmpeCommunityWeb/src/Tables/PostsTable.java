package Tables;

public class PostsTable {
	private int id;
	private int owner_id;
	private String body;
	private String posting_time;
	public PostsTable(int id, int owner_id, String body, String posting_time) {
		super();
		this.id = id;
		this.owner_id = owner_id;
		this.body = body;
		this.posting_time = posting_time;
	}
	public PostsTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPosting_time() {
		return posting_time;
	}
	public void setPosting_time(String posting_time) {
		this.posting_time = posting_time;
	}
}
