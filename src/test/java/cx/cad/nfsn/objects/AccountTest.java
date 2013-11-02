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

    @Test
    public void testGetBalanceCash(){
        WHEN.apiResponseIs("2345.23");
        assertThat(account.getBalanceCash(), equalTo(2345.23));
    }

    @Test
    public void testGetBalanceCredit(){
        WHEN.apiResponseIs("9879.87");
        assertThat(account.getBalanceCredit(), equalTo(9879.87));
    }

    @Test
    public void testGetBalanceHigh(){
        WHEN.apiResponseIs("0.13");
        assertThat(account.getBalanceHigh(), equalTo(0.13));
    }

    @Test
    public void testGetFriendlyName(){
        WHEN.apiResponseIs("\"friendlyName\"");
        assertThat(account.getFriendlyName(), equalTo("friendlyName"));
    }

}
