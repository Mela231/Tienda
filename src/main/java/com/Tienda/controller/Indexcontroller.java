package com.Tienda.controller;

import com.Tienda.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller /*Esto se llama anotación*/
public class Indexcontroller {
    
//    mapping:URL a los que responde
   @Autowired
    ProductoService productoService;
   
   @RequestMapping("/")
    public String page(Model model, HttpSession session) { 
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        return "index";
    }}
/*@Controller
public class Indexcontroller {
    
    @RequestMapping("/")
    public String page(Model model,HttpSession session) {
        
        String imagen = (String)session.getAttribute("usuarioImagen");
        model.addAttribute("avatar",imagen);
        return "index";
    }
    
}*/
