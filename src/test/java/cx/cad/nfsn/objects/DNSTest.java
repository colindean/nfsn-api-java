package cx.cad.nfsn.objects;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

public class DNSTest extends APIObjectTestParent{
    DNS dns;

    @Before
    public void before() {
        when(mockApi.getDNS("domain")).thenReturn(new DNS("example.com", mockApi));
        dns = mockApi.getDNS("domain");
    }
    @Test
    public void testGetExpire() {
        WHEN.apiResponseIs("5");
        assertThat(dns.getExpire(), equalTo(5L));
    }
    @Test
    public void testGetMinTTL() {
        WHEN.apiResponseIs("30");
        assertThat(dns.getMinTTL(), equalTo(30L));
    }
    @Test
    public void testGetRefresh() {
        WHEN.apiResponseIs("9999");
        assertThat(dns.getRefresh(), equalTo(9999L));
    }
    @Test
    public void testGetRetry() {
        WHEN.apiResponseIs("1111");
        assertThat(dns.getRetry(), equalTo(1111L));
    }
    @Test
    public void testSerial() {
        WHEN.apiResponseIs("234567890987632");
        assertThat(dns.getRetry(), equalTo(234567890987632L));
    }
    @Test
    public void testUpdateSerial() {
        WHEN.apiResponseIs("234567890987632");
        assertThat(dns.updateSerial(), equalTo(234567890987632L));
    }
    @Test
    public void testListRRsWithoutLimitations(){
        WHEN.apiResponseIs("[{\"name\":\"example.com\",\"type\":\"A\",\"data\":\"127.0.0.1\",\"ttl\":60},{\"name\":\"example.com\",\"type\":\"MX\",\"data\":\"mail.example.com\",\"ttl\":3600}]");
        assertThat(dns.listRRs(DNS.NO_LIMITATIONS), hasSize(2));
        assertThat(dns.listRRs(DNS.NO_LIMITATIONS).get(0).ttl, equalTo(60L));
        assertThat(dns.listRRs(DNS.NO_LIMITATIONS).get(1).data, equalTo("mail.example.com"));
    }
}
