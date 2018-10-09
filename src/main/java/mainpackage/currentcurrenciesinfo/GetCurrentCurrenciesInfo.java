package mainpackage.currentcurrenciesinfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
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

    public String getCurrenciesInfoFromFinanceUa() {

        ResponseEntity<String> responseEntity = this.get("http://resources.finance.ua", "/ru/public/currency-cash.json");
        String respBody = responseEntity.getBody();
        //Gson gson = new GsonBuilder().create();
        //JsonObject jsonObject = gson.fromJson(respBody, JsonObject.class);
        return respBody;
    }

    private ResponseEntity<String> get(String server, String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "text/*");
        RestTemplate rest = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
        return responseEntity;
    }

}
