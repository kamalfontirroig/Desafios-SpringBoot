package m5.seguridad.desafio1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginController {
	
	@GetMapping(value={"/login"})
	public ModelAndView login() {
		return new ModelAndView("login");
	}
}
