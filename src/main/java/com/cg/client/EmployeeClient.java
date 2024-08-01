package com.cg.client;

import com.cg.bo.ClientBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Component
public class EmployeeClient {

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ClientBO> getAllEmployees() {
        String url = "http://localhost:8080/emp";
        ResponseEntity<List<ClientBO>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ClientBO>>() {});
        return response.getBody();
    }
}
