package cx.cad.nfsn.models;

import java.util.Map;

public class AccountStatus {

    private String status;
    private String shortCode;
    private String color;

    private AccountStatus() {

    }

    public static AccountStatus newFromMap(Map<String, String> map) {
        AccountStatus as = new AccountStatus();

        as.setStatus(map.get("status"));
        as.setShortcode(map.get("short"));
        as.setColor(map.get("color"));

        return as;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setShortcode(String shortCode) {
        this.shortCode = shortCode;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getColor() {
        return color;
    }
}
