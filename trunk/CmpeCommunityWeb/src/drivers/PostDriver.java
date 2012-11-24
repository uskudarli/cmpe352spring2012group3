package drivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBPack.DBStatement;
import Tables.PostsTable;

public class PostDriver {

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
}
