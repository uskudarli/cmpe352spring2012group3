package Tables;

public class TagsTable {

	private String[] _tags;
	public TagsTable(String tags){
		_tags = tags.split(",");		
	}
	public String[] getTags(){
		return _tags;
	}
	
	
}
