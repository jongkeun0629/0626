package com.jongkeun.Calculator.controller;

import com.jongkeun.Calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String showCalculator(){
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculator(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation,
            Model model)
    {
//        System.out.println("Clicked " + "num1: " + num1 + ", operation: " + operation + ", num2: " + num2);

        try{
            double result = calculatorService.calculate(num1, num2, operation);
            System.out.println(result);

            model.addAttribute("result", result);
        } catch (IllegalArgumentException e){
            model.addAttribute("errorMessage", e.getMessage());
        }

        return "calculator";
    }
}