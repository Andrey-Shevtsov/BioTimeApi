package org.shevtsov.biotime;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.shevtsov.biotime.responses.GetAreaListResponse;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException, JsonProcessingException {
        Api api = new Api();
        String token = api.getJwtToken("admin", "admin123").getToken();
        System.out.println("Token is: " + token);
        int count = api.getAreaList(1, 10, token).getCount();
        System.out.println("Count is: " + String.valueOf(count));
    }
}