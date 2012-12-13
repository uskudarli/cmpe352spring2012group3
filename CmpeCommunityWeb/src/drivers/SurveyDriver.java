package drivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import DBPack.DBStatement;
import Tables.ChoiceTable;
import Tables.PostsTable;
import Tables.SurveyTable;

public class SurveyDriver {
	
	public static boolean createSurvey(int userId,String question,String[] choices) {
		try{
			String query="INSERT INTO surveys (question,user_id) VALUES (?,?)" ;	
			PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, question);
			ps.setInt(2, userId);
			ps.executeUpdate();
			ResultSet result = ps.getGeneratedKeys();
			if(!result.next())
				return false;
			int surveyId = result.getInt(1);
			if(!SurveyDriver.insertUsersInSurvey(userId,surveyId)){
				//TODO delete previously created post
				return false;
			}
			if(!SurveyDriver.insertChoices(surveyId,choices)){
				//TODO delete previously created post
				return false;
			}
			return true;
		}  catch(SQLException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}

public static boolean voteChoice(int choiceId) {
	try{
		String query="UPDATE choices set votes=votes+1 where id=?" ;	
		PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, choiceId);
		ps.executeUpdate();
		return true;
	}  catch(SQLException e) {
		return false;
	} catch (Exception e) {
		return false;
	}
}
public static SurveyTable getSurvey(int surveyId) {
	try {
		String query="SELECT * FROM `surveys` WHERE `id`=?";
		PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
		ps.setInt(1, surveyId);
		ResultSet result = ps.executeQuery();
		return new SurveyTable(result.getInt("id"),result.getInt("user_id"),result.getString("question"),getChoices(surveyId));
	} catch(SQLException e) {
		System.out.println(e.getMessage());
		return null;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return null;
	}
}
public static ChoiceTable[] getChoices(int surveyId) {
	try {
		String query="SELECT * FROM `choices` WHERE `survey_id`=?";
		PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query);
		ps.setInt(1, surveyId);
		ResultSet result = ps.executeQuery();
		return convertToArray(result);
	} catch(SQLException e) {
		System.out.println(e.getMessage());
		return new ChoiceTable[0];
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return new ChoiceTable[0];
	}
}
private static ChoiceTable[] convertToArray(ResultSet result) throws SQLException{
	int N = 0;
	while(result.next()) N++;
	result.beforeFirst();
	ChoiceTable[] choices = new ChoiceTable[N];
	int i=0;
	while(result.next())
		choices[i++] = new ChoiceTable(result.getInt("id"), result.getInt("survey_id"), result.getString("body"), result.getInt("votes"));
	return choices;
}
public static boolean insertUsersInSurvey(int userId,int surveyId) {
	try{
		String query="INSERT INTO users_in_survey (survey_id,user_id) VALUES (?,?)" ;	
		PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, surveyId);
		ps.setInt(2, userId);
		ps.executeUpdate();
		return true;
	}  catch(SQLException e) {
		return false;
	} catch (Exception e) {
		return false;
	}
	
}
private static boolean insertChoices(int surveyId, String[] choices) {
	try{
		for (int i=0;i<choices.length;i++) {
			
			if (!addChoice(surveyId,choices[i]))
				return false;
			
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}
private static boolean addChoice(int surveyId, String choice) {
	try{
		String query="INSERT INTO choices (survey_id,choice) VALUES (?,?,?)" ;	
		PreparedStatement ps=(PreparedStatement) DBStatement.getMainConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, surveyId);
		ps.setString(2, choice);
		ps.executeUpdate();
		return true;
	}  catch(SQLException e) {
		return false;
	} catch (Exception e) {
		return false;
	}
}
}