package com.docsbymario.root.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("templates/index.html");
        return modelAndView;
    }

    @GetMapping("/apps")
    public ModelAndView getApps() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("templates/apps.html");
        return modelAndView;
    }
}