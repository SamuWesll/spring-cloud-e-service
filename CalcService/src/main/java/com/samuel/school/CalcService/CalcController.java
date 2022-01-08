package com.samuel.school.CalcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class CalcController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/calc/{numOne}/{numTwo}")
    public String sum(@PathVariable Double numOne, @PathVariable Double numTwo) {
        String sumServiceResult= restTemplate.getForObject("http://sum-service/sum/{sumOne}/{sumTwo}", String.class, numOne, numTwo);
        Double calcServiceResult = numOne - numTwo;
        return "Return from all: " + sumServiceResult + " " + calcServiceResult;
    }

}
