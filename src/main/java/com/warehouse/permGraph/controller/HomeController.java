package com.warehouse.permGraph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("---home---");
        return "single";
    }

    @RequestMapping("/single")
    public String single(){
        System.out.println("---single---");
        return  "single";
    }

    @RequestMapping("/complex")
    public String complex(){
        System.out.println("---complex---");
        return  "complex";
    }
}
