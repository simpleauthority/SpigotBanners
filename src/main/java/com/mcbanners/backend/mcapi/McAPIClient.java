package com.mcbanners.backend.mcapi;

import com.mcbanners.backend.obj.McServer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class McAPIClient {
    private static final String BASE_URL = "https://mc.mcbanners.com/server/";
    private static final String USER_AGENT = "MCBanners";

    public ResponseEntity<McServer> getServer(String host) {
        return makeRequest(host, McServer.class);
    }

    public ResponseEntity<McServer> getServer(String host, int port) {
        return makeRequest(host + "/" + port, McServer.class);
    }

    private <T> ResponseEntity<T> makeRequest(String endpoint, Class<T> type) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", USER_AGENT);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        try {
            return template.exchange(
                    BASE_URL + endpoint,
                    HttpMethod.GET,
                    entity,
                    type
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}