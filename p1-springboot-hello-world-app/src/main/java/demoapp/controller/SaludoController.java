package demoapp.controller;

import demoapp.service.SaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SaludoController {

    @Autowired // Te permite utilizar clases que no están en este archivo sino en el archivo que se indica en la línea que sigue
    private SaludoService service;

    @RequestMapping("/saludo/{nombre}")
    public @ResponseBody String saludo(@PathVariable(value="nombre") String nombre) {
        return service.saluda(nombre);
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}