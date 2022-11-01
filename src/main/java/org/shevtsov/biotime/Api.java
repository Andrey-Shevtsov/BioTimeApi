package org.shevtsov.biotime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shevtsov.biotime.entities.Area;
import org.shevtsov.biotime.requests.*;
import org.shevtsov.biotime.responses.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Api {
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    public GetJwtTokenResponse getJwtToken(String name, String pass) throws URISyntaxException, JsonProcessingException {
        GetJwtTokenRequest request = new GetJwtTokenRequest(name, pass);
        byte[] requestBody = objectMapper.writeValueAsBytes(request);
        GetJwtTokenResponse response;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:25585/jwt-api-token-auth/"))
                .POST(HttpRequest.BodyPublishers.ofByteArray(requestBody))
                .header("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> output = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> responseBody = objectMapper.readValue(
                    output.body(),
                    new TypeReference<Map<String, Object>>() {}
            );
            response = new GetJwtTokenResponse((String) responseBody.get("token"), output.statusCode());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public GetAreaListResponse getAreaList(int page, int pageSize, String token) throws JsonProcessingException, URISyntaxException {
        GetAreaListRequest request = new GetAreaListRequest(page, pageSize);
        byte[] requestBody = objectMapper.writeValueAsBytes(request);
        GetAreaListResponse response;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:25585/personnel/api/areas/"))
                .GET()
                .header("Content-Type", "application/json")
                .header("Authorization", "JWT " + token)
                .build();
        try {
            HttpResponse<String> output = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> responseBody = objectMapper.readValue(
                    output.body(),
                    new TypeReference<Map<String, Object>>() {}
            );
            response = new GetAreaListResponse(
                    (Integer) responseBody.get("count"),
                    (String) responseBody.get("next"),
                    (String) responseBody.get("previous"),
                    (String) responseBody.get("msg"),
                    (Integer) responseBody.get("code"),
                    (Area[]) responseBody.get("data")
            );
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
