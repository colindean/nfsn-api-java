package cx.cad.nfsn.objects;

import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class AccountTest extends APIObjectTestParent {

    Account account;

    @Before
    public void before(){
        when(mockApi.getAccount("memberName")).thenReturn(new Account("ACCT-ID", mockApi));
        account = mockApi.getAccount("memberName");
    }

    @Test
    public void testGetBalance(){
        WHEN.apiResponseIs("5.95");
        assertThat(account.getBalance(), equalTo(5.95));
    }

}
