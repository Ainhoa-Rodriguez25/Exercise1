package demoapp.controller.calculator;

import demoapp.service.calculator.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService service;

    @GetMapping("/calculator")
    public String showForm(Model model) {
        model.addAttribute("calculatorData", new CalculatorData());

        return "calculator/calculatorForm";
    }

    @PostMapping("/calculator")
    public String calculate(@Valid CalculatorData calculatorData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "calculator/calculatorForm";
        }

        try {
            double calculationResult = service.calculate(
                    calculatorData.getNum1(),
                    calculatorData.getNum2(),
                    calculatorData.getOperation()
            );

            model.addAttribute("result", calculationResult);

            return "calculator/calculatorResult";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "calculator/calculatorForm";
        }
    }
}
