package mainpackage.currentcurrenciesinfo;

import com.google.gson.Gson;
import mainpackage.currentcurrenciesinfo.currenciesinfofinanceua.CurrencyStatsFinanceUa;
import mainpackage.currentcurrenciesinfo.currenciesinfofinanceua.Organization;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCurrentCurrenciesInfo {

    public CurrencyCurrentStatNBU[] CurrencyCurrentStatFromNBU() {
        Gson gson = new Gson();
        return gson.fromJson(getRespBodyByRestTemplate("https://bank.gov.ua",
                "/NBUStatService/v1/statdirectory/exchange?json"), CurrencyCurrentStatNBU[].class);
    }

    public CurrencyStatsFinanceUa CurrencyCurrentStatFromFinanceUa() {
        Gson gson = new Gson();
        return gson.fromJson(getRespBodyByRestTemplate("http://resources.finance.ua",
                "/ru/public/currency-cash.json"), CurrencyStatsFinanceUa.class);
    }

    private static String getRespBodyByRestTemplate(String server, String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "text/*");
        RestTemplate rest = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
        return responseEntity.getBody();
    }


    public static void main(String[] args) {
        Gson gson = new Gson();
        CurrencyStatsFinanceUa currencyStatsFinanceUa = gson.
                fromJson(getRespBodyByRestTemplate("http://resources.finance.ua",
                "/ru/public/currency-cash.json"), CurrencyStatsFinanceUa.class);

        List<Organization> organizationList = currencyStatsFinanceUa.getOrganizations();

        List<Double> ratesListUSD = new ArrayList<>();
        List<Double> ratesListEUR = new ArrayList<>();
        double sumUSD = 0;
        double sumEUR = 0;

        for (Organization organization : organizationList) {
            if (organization.getCurrencies().getUSD() != null)
            ratesListUSD.add(getDoubleFromString(organization.getCurrencies().getUSD().getBid()));
            sumUSD += ratesListUSD.get(ratesListUSD.size()-1);
            if (organization.getCurrencies().getEUR() != null)
            ratesListEUR.add(getDoubleFromString(organization.getCurrencies().getEUR().getBid()));
            sumEUR += ratesListEUR.get(ratesListEUR.size()-1);
        }

        double averUSD = sumUSD/ratesListUSD.size();
        double averEUR = sumEUR/ratesListEUR.size();

        System.out.println("USD " + averUSD + "; " + "EUR " + averEUR);

    }

    private static double getDoubleFromString(String string) {
        double number = 0;
        try {
            number = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return number;
    }


/*
    private static String getByRestAssured() {
        return RestAssured.
                given().
                get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json").
                asString();
    }
*/

}
