package constants;

public enum EndPoint {

    STORE("/store"),
    ACCOUNT("/account");

    public final String endPointUrl;

    EndPoint(String endPointUrl) {
        this.endPointUrl = endPointUrl;
    }
}
