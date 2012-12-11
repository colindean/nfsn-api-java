package cx.cad.nfsn.test;

import static org.junit.Assert.*;

import cx.cad.nfsn.*;

import org.junit.Before;
import org.junit.Test;

public class APITest {

	private API api;
	
	@Before
	public void setUp() throws Exception {
		this.api = new API("user","key",true);
	}

	@Test
	public void testAPI() {
		assertTrue(this.api.getClass().equals(API.class));
	}

	@Test
	public void testGetAccount() {
		assertTrue(this.api.getAccount("account").getClass().equals(Account.class));
	}

	@Test
	public void testGetDatabase() {
		assertTrue(this.api.getDatabase("database").getClass().equals(Database.class));
	}

	@Test
	public void testGetDNS() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSite() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateSalt() {
		String salt = api.generateSalt();
		assertEquals("Length must be 16", 16, salt.length());
		assertTrue("Must contain only letters and numbers", salt.matches("[a-zA-Z0-9]*"));
	}

}
