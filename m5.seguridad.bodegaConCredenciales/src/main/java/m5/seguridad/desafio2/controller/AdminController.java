//package m5.seguridad.desafio2.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import m5.seguridad.desafio2.dto.Material;
//
//@Controller
//public class AdminController {
//
//	List<Material> materialesAux = new ArrayList<Material>();
//
//	@GetMapping(value = { "/admin" })
//	public ModelAndView home() {
//		ModelAndView modelAndView = new ModelAndView("admin");
//		modelAndView.addObject("material", new Material());
//		modelAndView.addObject("materiales", materialesAux);
//		return modelAndView;
//	}
//
//	@PostMapping("/admin/nuevo")
//	public ModelAndView home(@ModelAttribute Material material) {
//		ModelAndView modelAndView = new ModelAndView("/materiales");
//		materialesAux.add(material);
//		modelAndView.addObject("materiales", materialesAux);
//		return modelAndView;
//	}
//}

