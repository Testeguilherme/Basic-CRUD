package com.api.vendas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

   @GetMapping("/")
   public String teste(){
       return "Teste";
   }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Olá mundo";
    }

}
