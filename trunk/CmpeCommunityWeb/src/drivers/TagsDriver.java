package drivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBPack.DBStatement;
import Tables.TagsTable;
import Tables.UserTable;

public class TagsDriver {
	public static boolean createTags(TagsTable[] tagsTable, Tables.UserTable userTable) throws Exception{
		userTable = drivers.UserDriver.getByEmail(userTable.getEmail());
		try {
			for (TagsTable table : tagsTable) {
				String str = table.getTag();
				// check if the tag already exists in the table
				Integer tag_id = tagId(str);
				// if new tag, insert to tags table
				if (tag_id == -1) {
					if (!insertTags(str)) {
						return false;
					}
					tag_id = tagId(str);
				}
				// get tag id
				table.setId(tag_id);
				insertTagsInUsers(userTable, table);
				// insert tag-user row to tags_in_users_table
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		} finally {
		}
		return false;
		
		
	}
	public static int tagId(String tag_name) {
		try{
			String query="SELECT * FROM tags where tag = ?" ;	
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setString(1, tag_name);
			ResultSet set = ps.executeQuery();
			if(!set.first()){
				return -1; // means false
			} else {
				return set.getInt("id");
			}
		}  catch(SQLException e) {
			return -1;
		} catch (Exception e) {
			return -1;
		} finally {
			
		}
	}
	public static boolean insertTags(String tag_name) {
		try{
			String query="INSERT INTO tags (tag) VALUES (?)";
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setString(1, tag_name);
			ps.executeUpdate();
		  return true; // means false
		}  catch(SQLException e) {
			return false;
		} catch (Exception e) {
			return false;
		} finally {
			
		}
		
	}
	public static boolean insertTagsInUsers(UserTable user,TagsTable tag) {
		try{
			String query="INSERT INTO tags_in_users (user_id,is_permanent,tagging_time,tag_id) VALUES (?,?,NOW(),?)" ;	
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.setBoolean(2, tag.getIsPermanent());
			ps.setInt(3, tag.getId());
			ps.executeUpdate();
		  return true; // means false
		}  catch(SQLException e) {
			return false;
		} catch (Exception e) {
			return false;
		} finally {
			
		}
	}
}	
