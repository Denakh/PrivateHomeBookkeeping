package mainpackage.currentcurrenciesinfo;

import com.google.gson.Gson;
import mainpackage.currentcurrenciesinfo.currenciesinfofinanceua.CurrencyStatsFinanceUa;
import mainpackage.currentcurrenciesinfo.currenciesinfofinanceua.Organization;
import mainpackage.entities.foreigncurrencies.Currencies;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetCurrentCurrenciesInfo {

    public Map<Currencies, Double> getCashAskRateWithUAHFromFinanceUa() {
        Map<Currencies, Double> currenciesCashAskRateMap = new HashMap<>();
        CurrencyStatsFinanceUa currencyStatsFinanceUa = currencyCurrentStatFromFinanceUa();
        List<Organization> organizationList = currencyStatsFinanceUa.getOrganizations();
        List<Double> ratesListUSDAsk = new ArrayList<>();
        List<Double> ratesListEURAsk = new ArrayList<>();
        double sumUSDAsk = 0;
        double sumEURAsk = 0;
        for (Organization organization : organizationList) {
            if (organization.getCurrencies().getUSD() != null) {
                ratesListUSDAsk.add(getDoubleFromString(organization.getCurrencies().getUSD().getAsk()));
                sumUSDAsk += ratesListUSDAsk.get(ratesListUSDAsk.size() - 1);
            }
            if (organization.getCurrencies().getEUR() != null) {
                ratesListEURAsk.add(getDoubleFromString(organization.getCurrencies().getEUR().getAsk()));
                sumEURAsk += ratesListEURAsk.get(ratesListEURAsk.size() - 1);
            }
        }
        double averUSDAsk = sumUSDAsk / ratesListUSDAsk.size();
        double averEURAsk = sumEURAsk / ratesListEURAsk.size();
        currenciesCashAskRateMap.put(Currencies.USD, averUSDAsk);
        currenciesCashAskRateMap.put(Currencies.EUR, averEURAsk);
        return currenciesCashAskRateMap;
    }

    public Map<Currencies, Double> getCashBidRateWithUAHFromFinanceUa() {
        Map<Currencies, Double> currenciesCashBidRateMap = new HashMap<>();
        CurrencyStatsFinanceUa currencyStatsFinanceUa = currencyCurrentStatFromFinanceUa();
        List<Organization> organizationList = currencyStatsFinanceUa.getOrganizations();
        List<Double> ratesListUSDBid = new ArrayList<>();
        List<Double> ratesListEURBid = new ArrayList<>();
        double sumUSDBid = 0;
        double sumEURBid = 0;
        for (Organization organization : organizationList) {
            if (organization.getCurrencies().getUSD() != null) {
                ratesListUSDBid.add(getDoubleFromString(organization.getCurrencies().getUSD().getBid()));
                sumUSDBid += ratesListUSDBid.get(ratesListUSDBid.size() - 1);
            }
            if (organization.getCurrencies().getEUR() != null) {
                ratesListEURBid.add(getDoubleFromString(organization.getCurrencies().getEUR().getBid()));
                sumEURBid += ratesListEURBid.get(ratesListEURBid.size() - 1);
            }
        }
        double averUSDBid = sumUSDBid / ratesListUSDBid.size();
        double averEURBid = sumEURBid / ratesListEURBid.size();
        currenciesCashBidRateMap.put(Currencies.USD, averUSDBid);
        currenciesCashBidRateMap.put(Currencies.EUR, averEURBid);
        return currenciesCashBidRateMap;
    }

    private CurrencyCurrentStatNBU[] currencyCurrentStatFromNBU() {
        Gson gson = new Gson();
        return gson.fromJson(getRespBodyByRestTemplate("https://bank.gov.ua",
                "/NBUStatService/v1/statdirectory/exchange?json"), CurrencyCurrentStatNBU[].class);
    }

    private CurrencyStatsFinanceUa currencyCurrentStatFromFinanceUa() {
        Gson gson = new Gson();
        return gson.fromJson(getRespBodyByRestTemplate("http://resources.finance.ua",
                "/ru/public/currency-cash.json"), CurrencyStatsFinanceUa.class);
    }

    private String getRespBodyByRestTemplate(String server, String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "text/*");
        RestTemplate rest = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
        return responseEntity.getBody();
    }

    private double getDoubleFromString(String string) {
        double number = 0;
        try {
            number = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return number;
    }

}
