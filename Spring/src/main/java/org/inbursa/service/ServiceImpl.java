package org.inbursa.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.inbursa.model.RequestCondusef;
import org.inbursa.model.ResponseCondusef;
import org.inbursa.model.ResponseGeneral;
import org.inbursa.utilidades.HttpCliente;
import org.inbursa.utilidades.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class ServiceImpl implements ServiceImpI{


    @Autowired
    RestClient restClient;

    @Autowired
    HttpCliente httpCliente;

    @Override
    public ResponseEntity<?> respuesta() throws JsonProcessingException {
        String url = "http://localhost:9000/error/condusef";
        RequestCondusef requestCondusef = RequestCondusef.builder()
                .env(1.2)
                .mensaje("doy informacion").build();
        ResponseGeneral responseGeneral = ResponseGeneral.builder()
                .mensaje("Consumo no correcto")
                .env("GCP")
                .version(1.1)
                .build();
        //ResponseEntity<?> respuesta =  restClient.request2(url, HttpMethod.GET, requestCondusef, ResponseCondusef.class);
        // Convertir el objeto RequestCondusef a una representación de texto
        String requestJson = convertRequestToJson(requestCondusef);
        try {
            HttpEntity entity = new StringEntity(requestJson);

            HttpResponse response = httpCliente.executeHttpRequest(url, entity);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseGeneral,HttpStatus.ACCEPTED);
    }

    // Método para convertir el objeto RequestCondusef a JSON utilizando Jackson
    private static String convertRequestToJson(RequestCondusef request) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(request);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
