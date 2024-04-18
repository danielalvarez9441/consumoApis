package org.inbursa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ServiceImpI {
    ResponseEntity<?> respuesta() throws JsonProcessingException;
}
