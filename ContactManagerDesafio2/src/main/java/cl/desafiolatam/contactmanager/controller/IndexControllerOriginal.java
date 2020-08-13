//package cl.desafiolatam.contactmanager.controller;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class IndexControllerOriginal implements ErrorController{
//
//    private static final String PATH = "/error";
//
//    @RequestMapping("/error")
//    public String error() {
//        return "<!DOCTYPE html>\r\n" + 
//        		"<html>\r\n" + 
//        		"<head>\r\n" + 
//        		"<meta charset=\"ISO-8859-1\">\r\n" + 
//        		"<title>UN ERROR GARRAFAL</title>\r\n" + 
//        		"</head>\r\n" + 
//        		"<body>\r\n" + 
//        		"No soy yo, eres tu.<br>\r\n" + 
//        		"Esto es un error, y si llegaste aqui, es muy probable que sea tu culpa.<br>\r\n" + 
//        		"\r\n" + 
//        		"Quieres volver a la zona segura?<br>\r\n" + 
//        		"<a href=\"/contactManager/\">Apretame</a>\r\n" + 
//        		"</body>\r\n" + 
//        		"</html>";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//}