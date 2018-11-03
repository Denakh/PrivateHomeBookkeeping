
package mainpackage.currentcurrenciesinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "r030",
    "txt",
    "rate",
    "cc",
    "exchangedate"
})
public class CurrencyCurrentStatNBU {

    @JsonProperty("r030")
    private int r030;
    @JsonProperty("txt")
    private String txt;
    @JsonProperty("rate")
    private double rate;
    @JsonProperty("cc")
    private String cc;
    @JsonProperty("exchangedate")
    private String exchangedate;

    @JsonProperty("r030")
    public int getR030() {
        return r030;
    }

    @JsonProperty("r030")
    public void setR030(int r030) {
        this.r030 = r030;
    }

    @JsonProperty("txt")
    public String getTxt() {
        return txt;
    }

    @JsonProperty("txt")
    public void setTxt(String txt) {
        this.txt = txt;
    }

    @JsonProperty("rate")
    public double getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(double rate) {
        this.rate = rate;
    }

    @JsonProperty("cc")
    public String getCc() {
        return cc;
    }

    @JsonProperty("cc")
    public void setCc(String cc) {
        this.cc = cc;
    }

    @JsonProperty("exchangedate")
    public String getExchangedate() {
        return exchangedate;
    }

    @JsonProperty("exchangedate")
    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

}
