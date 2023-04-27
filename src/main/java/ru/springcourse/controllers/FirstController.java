package ru.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") double number1,
                                 @RequestParam(value = "b") double number2,
                                 @RequestParam(value = "action") String action,
                                 Model model) {
        double result = 0d;

        switch (action) {
            case "multiplication" :
                result = number1 * number2;
                break;
            case "addition":
                result = number1 + number2;
                break;
            case "subtraction":
                result = number1 - number2;
                break;
            case "division":
                result = number1 / number2;
                break;
            default:

                return "first/calculatorIncorrect";
        }

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("action", action);
        model.addAttribute("result", result);

        return "first/calculator";
    }
}
