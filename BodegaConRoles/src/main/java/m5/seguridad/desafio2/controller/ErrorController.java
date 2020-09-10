package m5.seguridad.desafio2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping("/forbidden")
    public ModelAndView recurso03() {
        return new ModelAndView("403");
    }

}
