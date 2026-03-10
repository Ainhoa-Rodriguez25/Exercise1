package demoapp.controller.factorial;

import demoapp.service.factorial.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FactorialController {
    @Autowired
    private FactorialService service;

    @GetMapping("/factorial")
    public String showForm(Model model) {
        model.addAttribute("factorialData", new FactorialData());

        return "factorial/factorialForm";
    }

    @PostMapping("/factorial")
    public String calculate(@Valid FactorialData factorialData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "factorial/factorialForm";
        }

        long factorialResult = service.calculateFactorial(factorialData.getNumber());

        model.addAttribute("result", factorialResult);

        return "factorial/factorialResult";
    }
}
