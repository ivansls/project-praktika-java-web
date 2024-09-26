package com.web_project.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name", "IVAN DENISOVICH");
        return "home";
    }

    @PostMapping("converter")
    public String converter(@RequestParam("currency1") String currency1,
                                     @RequestParam("currency2") String currency2,
                                     @RequestParam("sum") double sum, Model model){
        double usdToEur = 0.94;
        double usdToRub = 96.5;
        double eurToUsd = 1.06;
        double eurToRub = 102.5;
        double rubToUsd = 0.0104;
        double rubToEur = 0.0098;
        double result = 0;
        if (currency1.equals("USD") && currency2.equals("EUR")) {
            result = sum * usdToEur;
        } else if (currency1.equals("USD") && currency2.equals("RUB")) {
            result = sum * usdToRub;
        } else if (currency1.equals("EUR") && currency2.equals("USD")) {
            result = sum * eurToUsd;
        } else if (currency1.equals("EUR") && currency2.equals("RUB")) {
            result = sum * eurToRub;
        } else if (currency1.equals("RUB") && currency2.equals("USD")) {
            result = sum * rubToUsd;
        } else if (currency1.equals("RUB") && currency2.equals("EUR")) {
            result = sum * rubToEur;
        }
        model.addAttribute("result", result);
        return "result_converter";
    }
    @GetMapping("/currency_converter")
    public String  currency_converter(Model model){
        return "currency_converter";
    }
    @PostMapping("calculate")
    public String calculate(@RequestParam("operand1") double operand1,
                            @RequestParam("operand2") double operand2,
                            @RequestParam("operator") String operator, Model model){
        double result = switch (operator){
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> 0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }
    @GetMapping("/calculator")
    public String calculator(Model model){
        return "calculator";
    }


}
