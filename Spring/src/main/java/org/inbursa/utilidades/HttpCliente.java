package org.inbursa.utilidades;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class HttpCliente {

    public HttpResponse executeHttpRequest(String url, HttpEntity entity) throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGetWithEntity request = new HttpGetWithEntity();
        request.setURI(new URI(url));
        request.setEntity(entity);
        return httpClient.execute(request);
    }



}
