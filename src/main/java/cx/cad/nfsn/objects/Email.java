package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;

import java.util.HashMap;

public class Email extends APIObject {

    private static final String type = "email";


    public Email(String domain, API api) {
        super(domain, api, type);
    }

    //methods

    public String getInfo() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public HashMap<String, String> listForwards() throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void removeForward(String user) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void setForward(String fromUser, String toAddress) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    //convenience methods?

    public void setBounce(String user) throws NotYetImplementedHereException {
        setForward(user, "bounce@nearlyfreespeech.net");
    }

    public void setDiscard(String user) throws NotYetImplementedHereException {
        setForward(user, "discard@nearlyfreespeech.net");
    }


    //no properties!
}