package mainpackage.currentcurrenciesinfo.currenciesinfofinanceua;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CLP {

    @SerializedName("ask")
    @Expose
    private String ask;
    @SerializedName("bid")
    @Expose
    private String bid;

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

}
