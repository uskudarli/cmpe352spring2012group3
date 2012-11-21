package Tables;

public class TagsTable {

	
	private String  _tag;
	private Integer _id;
	private Boolean _isPermanent = true;
	
	public TagsTable(String tags){
		_tag = tags;
	}
	public TagsTable(String tags,Integer id){
		_tag = tags;
		_id = id;
	}
	public TagsTable(String tags,Boolean isPermanent){
		_tag = tags;
		_isPermanent = isPermanent;
	}
	public TagsTable(String tags,Integer id,Boolean isPermanent){
		_tag = tags;
		_id = id;
		_isPermanent = isPermanent;
	}
	public String getTag() {
		return _tag;
	}
	public void setTag(String tag) {
		this._tag = tag;
	}
	public Integer getId() {
		return _id;
	}
	public void setId(Integer id) {
		this._id = id;
	}
	public Boolean getIsPermanent() {
		return _isPermanent;
	}
	public void setIsPermanent(Boolean isPermanent) {
		this._isPermanent = isPermanent;
	}
	
	
}
