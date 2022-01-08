package com.samuel.school.SumService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SumController {

    @Value("${spring.application.name}")
    private String serviceNaeme;

    @GetMapping("/sum/{numOne}/{numTwo}")
    public String sum(@PathVariable Double numOne, @PathVariable Double numTwo) {
        Double result = numOne + numTwo;
        return serviceNaeme + " " + result;
    }
}
