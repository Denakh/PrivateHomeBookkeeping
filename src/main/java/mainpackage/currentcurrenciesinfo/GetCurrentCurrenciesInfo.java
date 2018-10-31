package mainpackage.currentcurrenciesinfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class GetCurrentCurrenciesInfo {

    //@Autowired
    //private ListenedUrlService listenedUrlService;

    public static void main(String[] args) {
        Gson gson = new Gson();
        Currency[] array = gson.fromJson(getByRestAssured(), Currency[].class);
        System.out.println(array.length);
    }

    private static String getByRestAssured() {
       return RestAssured.
                given().
                get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json").
                asString();
    }

}
