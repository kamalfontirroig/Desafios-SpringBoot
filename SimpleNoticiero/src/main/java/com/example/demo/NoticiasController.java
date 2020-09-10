package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticiasController {

private static final Logger log = LoggerFactory.getLogger(NoticiasController.class);

	@GetMapping({"/","/home","/news"})
	public String home(ModelMap model) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("noticias.txt"));
		if (fin == null) {
			log.error("El archivo noticias.txt no se encontro o no pudo abrirse");
		}else {
			log.info("Las noticias estan listas para ser cargadas:");
		}
		String textLine;
		int numeroNoticia=0;
		while ((textLine = fin.readLine()) !=null) {
			//0: titulo
			//1: cuerpo
			//2: imagenUrl
			numeroNoticia++;
			log.info(textLine);
			String[] dataArray= textLine.split("@@");
			
			model.addAttribute("noticiaArray"+numeroNoticia,dataArray);
		}
		
		return "homenews";
	}
}
