package com.icom.alepayorder.controller;

import com.google.gson.Gson;
import com.icom.alepayorder.dto.RequestBodyListPackage;
import com.icom.alepayorder.dto.ResponseListPackage;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping(value = "/list-package", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getListPackage() {
        String uri = "http://dev.games360.vn/rest/list-package";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        RequestBodyListPackage requestBodyListPackage = new RequestBodyListPackage();
        requestBodyListPackage.setUsername("VTVLIVE");
        requestBodyListPackage.setPswd("7095fb6fc853424255db85e12348cb31");
        requestBodyListPackage.setRequest_id("VTVLIVE1625620714830");


        HttpEntity<String> entity = new HttpEntity<>(new Gson().toJson(requestBodyListPackage) ,headers);

        ResponseEntity<String> response = restTemplate.exchange(
                uri, HttpMethod.POST, entity, String.class);
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
