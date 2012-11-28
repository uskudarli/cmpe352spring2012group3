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

	@Test
	public void testCreateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCredentialsValid() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByEmail() {
		String email = "test@test.com";
		UserTable  user = UserDriver.getByEmail(email);
		Assert.assertEquals("Email"	, email, user.getEmail());
	}

}
