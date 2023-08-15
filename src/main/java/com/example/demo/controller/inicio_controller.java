/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Alvar
 */
@Controller
@RequestMapping("/docsfriends")
public class inicio_controller {

    @GetMapping("/inicio")
    public String vista(Model mo)
    {
        return "inicio";
    }
    
    @GetMapping("/iniciosession")
    public String login(Model mo)
    {
        return "iniciodesesion";
    }
    
    
    @GetMapping("/home")
    public String iniciousuario(Model mo)
    {
        return "iniciousuario";
    }
    
    @GetMapping("/logouteq")
    public String logo(Model mo)
    {
        return "ss.jpg";
    }


}
