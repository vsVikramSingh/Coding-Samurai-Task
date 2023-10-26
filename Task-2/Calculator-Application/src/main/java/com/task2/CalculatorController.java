package com.task2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("expression") String expression, Model model) {
        try {
            double result = evaluateExpression(expression);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("error", "Invalid expression");
        }
        return "calculator";
    }

    private double evaluateExpression(String expression) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            return (double) engine.eval(expression);
        } catch (Exception e) {
            throw new RuntimeException("Invalid expression");
        }
    }
}
