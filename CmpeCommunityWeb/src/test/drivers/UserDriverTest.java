package test.drivers;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Tables.UserTable;
import drivers.UserDriver;

public class UserDriverTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testCreateUser() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testIsCredentialsValid() {
		String email="test@test.com";
		String password_hash="gwRqWu588Ocd6otgdTBhQw==";
		UserTable user= UserDriver.getByEmail(email);
		Assert.assertEquals("Credentials Valid"	, password_hash, user.getPassword_hash());	
	}

	@Test
	public void testGetById() {
		int id = 15;
		UserTable  user = UserDriver.getById(id);
		Assert.assertEquals("Got user by id"	, id, user.getId());
	}

	@Test
	public void testGetByEmail() {
		String email = "test@test.com";
		UserTable  user = UserDriver.getByEmail(email);
		Assert.assertEquals("Email"	, email, user.getEmail());
	}
	
	/*@Test
	public void testGetUsersByTag(){
		int tagId=5;
		UserTable[] user=UserDriver.getUsersByTag(tagId);
		
		
		
	}*/

}