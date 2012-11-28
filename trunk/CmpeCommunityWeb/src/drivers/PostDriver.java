package drivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBPack.DBStatement;
import Tables.PostsTable;

public class PostDriver {
    
	public static PostsTable[] getWallPosts(int user_id) {
		try {
			String query="(select * from posts where owner_id=?) union (select * from posts where id in (select post_id from users_in_posts where user_id=?))";
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setInt(2, user_id);
			ResultSet result = ps.executeQuery();
			return convertToArray(result);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}  catch (Exception e) {
			System.out.println(e.getMessage());
			return new PostsTable[0];
		}
	}
	public static PostsTable[] getPostsByUserId(int id){
		try {
			String query="SELECT * FROM `posts` WHERE `owner_id`=? ORDER BY posting_time desc";
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			return convertToArray(result);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return new PostsTable[0];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PostsTable[0];
		}
	}
	
	public static PostsTable[] getPostsByTag(int tagId){
		try {
			String query="SELECT * FROM `posts` INNER JOIN `tags_in_posts` ON `posts`.`id`=`tags_in_posts`.`post_id` WHERE `tags_in_posts`.`tag_id`=?";
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setInt(1, tagId);
			ResultSet result = ps.executeQuery();
			return convertToArray(result);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return new PostsTable[0];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PostsTable[0];
		}
	}
	
	private static PostsTable[] convertToArray(ResultSet result) throws SQLException{
		int N = 0;
		while(result.next()) N++;
		result.beforeFirst();
		PostsTable[] posts = new PostsTable[N];
		int i=0;
		while(result.next())
			posts[i++] = new PostsTable(result.getInt("id"), result.getInt("owner_id"), result.getString("body"), result.getString("posting_time"));
		return posts;
	}
	public static boolean addPosts(int user_id,String post) {
		try{
			String query="INSERT INTO posts (owner_id,body,posting_time) VALUES (?,?,NOW())" ;	
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setString(2,post);
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
