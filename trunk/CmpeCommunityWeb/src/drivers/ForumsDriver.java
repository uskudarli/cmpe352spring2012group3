package drivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBPack.DBStatement;
import Tables.ForumTopicTable;
import Tables.ForumsTable;

public class ForumsDriver {
	public static int createTopic(int forumId, String title, int userId, String content){
		try{
			String query="INSERT INTO forum_topics (forum_id, title, replies_count, views_count, creation_time, user_id, last_post_id) VALUES (?, ?, 0, 0, NOW(), ?, 0)" ;	
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, forumId);
			ps.setString(2, title);
			ps.setInt(3, userId);
			ps.executeUpdate();
			ResultSet result = ps.getGeneratedKeys();
			if(!result.next())
				return 0;
			int id = result.getInt(1);
			if(createPost(content, userId, id))
				return id;
			removeTopic(id);
			return 0;
		}  catch(SQLException e) {
			e.printStackTrace();
			return 0;
		} catch (Exception e) {
			return 0;
		} finally {

		}
	}
	
	public static ForumTopicTable[] getTopicsByForumId(int forumId){
		return null;
	}
	
	public static boolean createPost(String content, int userId, int topicId){
		try{
			String query="INSERT INTO forum_posts (content, post_time, user_id, topic_id) VALUES (?, NOW(), ?, ?)" ;
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setString(1, content);
			ps.setInt(2, userId);
			ps.setInt(3, topicId);
			ps.executeUpdate();
			return true;
		}  catch(SQLException e) {
			return false;
		} catch (Exception e) {
			return false;
		} finally {

		}
	}
	
	public static void removeTopic(int topicId){/*
		try{
			String query="INSERT INTO forum_posts (content, post_time, user_id, topic_id) VALUES (?, NOW(), ?, ?)" ;
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
			ps.setString(1, content);
			ps.setInt(2, userId);
			ps.setInt(3, topicId);
			ps.executeUpdate();
			return true;
		}  catch(SQLException e) {
			return false;
		} catch (Exception e) {
			return false;
		} finally {

		}*/
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
	
	private static ForumTopicTable[] convertToTopicsArray(ResultSet result) throws SQLException{
		int N = 0;
		while(result.next()) N++;
		result.beforeFirst();
		ForumTopicTable[] forums = new ForumTopicTable[N];
		int i=0;
		while(result.next())
			forums[i++] = null;//new ForumTopicTable(result.getInt("id"), result.getInt("forum_id"), result.getString("title"), , viewsCount, creationTime, userId, lastPostId)
		return forums;
		
	}
}
