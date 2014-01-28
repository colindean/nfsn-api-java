package cx.cad.nfsn.objects;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;

public class EmailTest extends APIObjectTestParent {

    Email email;

    @Before
    public void before() {
        when(mockApi.getEmail("email@example;com")).thenReturn(new Email("email@example.com", mockApi));
        email = mockApi.getEmail("example@example.com");
    }

    @Ignore(value = "Not yet implemented")
    @Test
    public void testListForwards() throws APIObject.NotYetImplementedHereException {
        WHEN.apiResponseIs("[\"root@example.com\",\"user@example.com\"]");
        assertThat(email.listForwards(), hasKey("root@example.com"));
    }

    @Ignore(value = "Not yet implemented")
    @Test
    public void testRemoveForward() throws APIObject.NotYetImplementedHereException {
        WHEN.apiResponseIs("");
        //assertNull(email.removeForward("root@example.com"));
    }

    @Ignore(value = "Not yet implemented")
    @Test
    public void testSetForward() throws APIObject.NotYetImplementedHereException {
        WHEN.apiResponseIs("");
        //assertNull(email.setForward("root@example.com", "user@example.com"));
    }
}
