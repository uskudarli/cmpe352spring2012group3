package drivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Tables.TagsTable;

import DBPack.DBStatement;

public class TagsDriver {
	public boolean createTags(TagsTable[] tagsTable, Tables.UserTable userTable){
		try{
			DBStatement db=new DBStatement();
			for(TagsTable table : tagsTable){
				String str = table.getTag();
				//check if the tag already exists in the table
				String query="SELECT * FROM tags where tag = ?" ;	
				PreparedStatement ps=(PreparedStatement) db.getConnection().prepareStatement(query);
				ps.setString(1, str);
				ResultSet set = ps.executeQuery();
				//if new tag, insert to tags table
				if(!set.first()){
					query="INSERT INTO tags (tag) VALUES (?)";
					ps.setString(1, str);
					ps.executeUpdate();
					//select id from
					query="SELECT FROM tags WHERE tag = ?";
					ps.setString(1, str);
					set = ps.executeQuery();
				}
				//get tag id
				Integer tag_id = set.getInt("id");
				userTable = drivers.UserDriver.getByEmail(userTable.getEmail());
				Integer user_id = userTable.getId();
				//insert tag-user row to tags_in_users_table 
				query="INSERT INTO tags_in_users (user_id,is_permanent,tagging_time,tag_id) VALUES (?,?,NOW(),?)" ;	
				ps.setInt(1, user_id);
				ps.setBoolean(2, table.getIsPermanent());
				ps.setInt(3, tag_id);
				ps.executeQuery();
			}
			
		} catch(SQLException e) {
			System.err.println("SQLException: "+e.getMessage());
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return false;
		
		
	}

}
