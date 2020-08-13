package m5.seguridad.desafio1.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import m5.seguridad.desafio1.dto.Material;

@Controller
@RequestMapping("")
public class MaterialesController {

	  List<Material> materialesAux;
	  
	  private MaterialesController() {
		materialesAux =  new ArrayList<Material>();
	}
	
	 @GetMapping(value={"/materiales", ""})
	    public ModelAndView home(HttpSession session) {
	        ModelAndView modelAndView = new ModelAndView("materiales");
	        modelAndView.addObject("material", new Material());
	        modelAndView.addObject("materiales", session.getAttribute("materiales"));
	        return modelAndView;
	    }
	 
	    @PostMapping("/materiales/nuevo")
	    public ModelAndView home(HttpSession session, @ModelAttribute Material material) {
	    	ModelAndView modelAndView = new ModelAndView("/materiales");
	    	materialesAux = new ArrayList<Material>();
	    	if (session.getAttribute("materiales") != null)
	            materialesAux.addAll((ArrayList<Material>) session.getAttribute("materiales"));
	        materialesAux.add(material);
	        session.setAttribute("materiales", materialesAux);
	        modelAndView.addObject("materiales", session.getAttribute("materiales"));
	        return modelAndView;
	    }
}
