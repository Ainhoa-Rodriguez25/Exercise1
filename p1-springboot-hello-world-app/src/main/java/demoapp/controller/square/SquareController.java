package demoapp.controller.square;

import demoapp.service.square.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SquareController {
    @Autowired
    private SquareService service;

    @GetMapping("/square")
    public String showForm(Model model) {
        model.addAttribute("squareData", new SquareData());

        return "squareForm";
    }

    @PostMapping("/square")
    public String checkSquare(@Valid SquareData squareData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "squareForm";
        }

        boolean isSquare = service.isSquare(squareData.getNum1(), squareData.getNum2());
        model.addAttribute("result", isSquare);

        return "squareResult";
    }
}
