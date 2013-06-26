package cx.cad.nfsn.test.integration;

import static org.junit.Assert.*;

import cx.cad.nfsn.*;

import org.junit.Before;
import org.junit.Test;

public class APITest {

	private API api;

  @Before
  public void setUp() throws Exception {
    String user = System.getEnv("NSFN_USER");
    String key = System.getEnv("NSFN_KEY");
    this.api = new API(user, key, true);
  }

  @Test
  public void testAccountStatus(){
    Account a = api.getAccount(System.getEnv("NSFN_TEST_ACCOUNT"));
    HashMap statusHash = a.getStatus();
    assertNotNull(statusHash.get("status"));
    assertNotNull(statusHash.get("short"));
    assertNotNull(statusHash.get("color"));
  }
}
