package com.jongkeun.Calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(double num1, double num2, String operation){
        switch (operation){
            case "add":
                return num1 + num2;
            case "sub":
                return num1 - num2;
            case "mul":
                return num1 * num2;
            case "div":
                if(num2 == 0){
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("허용되지 않은 연산자: " + operation);
        }
    }
}
