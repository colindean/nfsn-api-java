package cx.cad.nfsn;

import cx.cad.nfsn.models.AccountStatus;
import cx.cad.nfsn.objects.APIObject;
import cx.cad.nfsn.objects.Account;
import cx.cad.nfsn.objects.Member;
import cx.cad.nfsn.objects.Site;

import java.util.List;

public class Examples {
    public static void main(String[] args) {
        String login = System.getenv("NFSN_LOGIN");
        String apiKey = System.getenv("NFSN_KEY");
        API api = new API(login, apiKey);

        Member member = api.getMember(login);
        try {
            System.out.println(String.format("Member %s, email is %s, status is %s",
                    member.getIdentifier(), member.getEmail(), member.getStatus()));
        } catch (APIObject.NFSNNotYetImplementedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        List<Account> list = member.getAccounts();
        for (Account a : list) {
            Double balance = a.getBalance();
            String id = a.getIdentifier();
            System.out.println(String.format("Account %s has %f balance.", id, balance));
            String friendlyName = a.getFriendlyName();
            System.out.println(String.format("Account %s has friendlyName %s.", id, friendlyName));
            AccountStatus as = a.getStatus();
            System.out.println(String.format("Status: %s: %s (%s)", as.getShortCode(), as.getStatus(), as.getColor().toString()));
            System.out.print("Sites: ");
            for (Site s : a.getSites()) {
                System.out.print(s.getIdentifier() + " ");
            }
            System.out.println();
        }
    }
}
