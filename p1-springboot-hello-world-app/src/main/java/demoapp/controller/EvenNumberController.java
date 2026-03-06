package demoapp.controller;

import demoapp.service.EvenNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EvenNumberController {

    @Autowired
    private EvenNumberService service;

    @GetMapping("/even")
    public String showForm(Model model) {
        model.addAttribute("evenNumberData", new EvenNumberData());

        return "evenForm";
    }

    @PostMapping("/even")
    public String checkEven(@Valid EvenNumberData evenNumberData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "evenForm";
        }

        boolean isEven = service.isEven(evenNumberData.getNumber());
        model.addAttribute("result", isEven);

        return "evenResult";
    }
}
