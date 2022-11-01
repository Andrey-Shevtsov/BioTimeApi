package org.shevtsov.biotime.responses;

public class GetJwtTokenResponse {
    private int statusCode;
    private String token;

    public String getToken() {
        return token;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public GetJwtTokenResponse(String token, int statusCode) {
        this.token = token;
        this.statusCode = statusCode;
    }
}
