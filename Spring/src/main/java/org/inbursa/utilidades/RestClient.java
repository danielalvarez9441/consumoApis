package org.inbursa.utilidades;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    public ResponseEntity<?> request(String url, HttpMethod method, Object requestBody, Class<?> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody);
        return restTemplate.exchange(url, method, requestEntity, responseType);
    }

    public ResponseEntity<?> request2(String url, HttpMethod method, Object requestBody, Class<?> responseType) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();


        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBodyJson, headers);


        return restTemplate.exchange(url, method, requestEntity, responseType);
    }

}
