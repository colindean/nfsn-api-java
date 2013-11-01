package cx.cad.nfsn;

import cx.cad.nfsn.objects.Account;
import cx.cad.nfsn.objects.Member;
import cx.cad.nfsn.objects.Site;

import java.util.List;

public class Examples {
    public static void main(String[] args){
        String login = System.getenv("NFSN_LOGIN");
        String apiKey = System.getenv("NFSN_KEY");
        API api = new API(login, apiKey);

        Member member = api.getMember(login);
        List<Account> list = member.getAccounts();
        for(Account a : list){
            Double balance = a.getBalance();
            String id = a.getIdentifier();
            System.out.println(String.format("Account %s has %f balance.", id, balance));
            System.out.print("Sites: ");
            for(Site s : a.getSites()){
                System.out.print(s.getIdentifier() + " ");
            }
            System.out.println();
        }
    }
}
