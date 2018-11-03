
package mainpackage.currentcurrenciesinfo.currenciesinfofinanceua;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyStats {

    @SerializedName("sourceId")
    @Expose
    private String sourceId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("organizations")
    @Expose
    private List<Organization> organizations = null;
    @SerializedName("orgTypes")
    @Expose
    private OrgTypes orgTypes;
    @SerializedName("currencies")
    @Expose
    private Currencies_ currencies;
    @SerializedName("regions")
    @Expose
    private Regions regions;
    @SerializedName("cities")
    @Expose
    private Cities cities;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public OrgTypes getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(OrgTypes orgTypes) {
        this.orgTypes = orgTypes;
    }

    public Currencies_ getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies_ currencies) {
        this.currencies = currencies;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

}
