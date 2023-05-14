package com.example.serviceweb10;

import com.example.serviceweb10.CalculatorWs.AddResponse;
import com.example.serviceweb10.CalculatorWs.DivideResponse;
import com.example.serviceweb10.CalculatorWs.MultiplyResponse;
import com.example.serviceweb10.CalculatorWs.SubtractResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorClient calculatorClient;

    @Autowired
    public CalculatorController(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        AddResponse response = calculatorClient.sum(a, b);
        return response.getAddResult();
    }

    @GetMapping("/multiply")
    public MultiplyResponse multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculatorClient.multiply(a, b);
    }

    @GetMapping("/divide")
    public DivideResponse divide(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculatorClient.divide(a, b);
    }

    @GetMapping("/subtract")
    public SubtractResponse subtract(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculatorClient.subtract(a, b);
    }

}