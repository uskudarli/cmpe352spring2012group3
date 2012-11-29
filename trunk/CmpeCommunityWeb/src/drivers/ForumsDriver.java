package drivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBPack.DBStatement;
import Tables.ForumsTable;

public class ForumsDriver {
	public static boolean create(){
		return false;
	}
	
	public static ForumsTable getById(int id){
		ForumsTable table = null;
		try{
			String query="SELECT * FROM `forums` WHERE `id` = ?";
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next())
				table = new ForumsTable(result.getInt("id"), result.getInt("parent_id"), result.getString("name"), result.getString("description"), result.getInt("topics_count"), result.getInt("posts_count"), result.getInt("last_post_id"));
		} catch(SQLException e) {
		} catch (Exception e) {
		}
		return table;
	}
	
	public static ForumsTable[] getCategories(){
		try{
			String query="SELECT * FROM `forums` WHERE ISNULL(`parent_id`) ORDER BY `id`";
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ResultSet result = ps.executeQuery();
			return convertToArray(result);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return new ForumsTable[0];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ForumsTable[0];
		}
	}
	
	public static ForumsTable[] getByParentId(int id){
		try{
			String query="SELECT * FROM `forums` WHERE `parent_id`=? ORDER BY `id`";
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			return convertToArray(result);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return new ForumsTable[0];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ForumsTable[0];
		}
	}
	
	public static ForumsTable[] getParentsById(int id){
		ArrayList<ForumsTable> parents = new ArrayList<ForumsTable>();
		while(id > 0){
			ForumsTable parent = getById(id);
			parents.add(parent);
			id = parent.getParentId();
		}
		ForumsTable[] ret = new ForumsTable[parents.size()]; 
		return parents.toArray(ret);
	}
	
	private static ForumsTable[] convertToArray(ResultSet result) throws SQLException{
		int N = 0;
		while(result.next()) N++;
		result.beforeFirst();
		ForumsTable[] forums = new ForumsTable[N];
		int i=0;
		while(result.next())
			forums[i++] = new ForumsTable(result.getInt("id"), result.getInt("parent_id"), result.getString("name"), result.getString("description"), result.getInt("topics_count"), result.getInt("posts_count"), result.getInt("last_post_id"));
		return forums;
		
	}
}
