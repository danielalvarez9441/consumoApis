package org.inbursa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.inbursa.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerApp {

    @Autowired
    ServiceImpl service;

    @GetMapping("/consume")
    public ResponseEntity<?> consume() throws JsonProcessingException {
        return   service.respuesta();
    }
}
