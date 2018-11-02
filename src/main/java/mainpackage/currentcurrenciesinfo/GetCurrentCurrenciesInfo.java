package mainpackage.currentcurrenciesinfo;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.health.Health;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetCurrentCurrenciesInfo {

    //@Autowired
    //private ListenedUrlService listenedUrlService;

    public static void main(String[] args) {
        Gson gson = new Gson();
        Currency[] array = gson.fromJson(getRespBodyByRestTemplate("https://bank.gov.ua",
                "/NBUStatService/v1/statdirectory/exchange?json"), Currency[].class);
        System.out.println(array.length);
        for (Currency currency : array) {
            switch (currency.getTxt()) {
                case "Долар США":
                    System.out.println("USD: " + currency.getRate());
                    break;
                case "Євро":
                    System.out.println("EUR: " + currency.getRate());
                    break;
            }
        }

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

/*
    private static String getByRestAssured() {
        return RestAssured.
                given().
                get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json").
                asString();
    }
*/
}
