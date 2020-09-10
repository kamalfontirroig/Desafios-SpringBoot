package relaciones.desafio1.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping("/error")
    public String error() {
        return "<!DOCTYPE html>\r\n" + 
        		"<html>\r\n" + 
        		"<head>\r\n"
        		+ "<!-- Bootstrap CSS -->\r\n" + 
        		"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"  integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
        		"<meta charset=\"ISO-8859-1\">\r\n" + 
        		"<title>UN ERROR GARRAFAL</title>\r\n" + 
        		"</head>\r\n" + 
        		"<body style=\"padding-top: 100px; text-align: center;\">\r\n" + 
        		"<h1>No soy yo, eres tu.</h1><br>\r\n" + 
        		"Esto es un error, y si llegaste aqui, es muy probable que sea tu culpa.<br>\r\n" + 
        		"\r\n" + 
        		"¿Quieres volver a la zona segura?<br>\r\n" + 
        		"<a href=\"/pasajero/lista\">Si, porfavor</a>\r\n"
        		+ " <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
        		"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n" + 
        		"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n" + 
        		"</body>\r\n" + 
        		"</html>";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}