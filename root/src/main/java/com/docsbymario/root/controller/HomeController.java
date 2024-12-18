package com.docsbymario.root.controller;

import com.docsbymario.root.entity.App;
import com.docsbymario.root.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeController {
    @Autowired
    private AppService appService;
    @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/apps")
    public ModelAndView getApps(@RequestParam(name="app-query", required=false) String appQuery,
                                @RequestParam(name="app-query-mobile", required=false) String appQueryMobile) {
        String query = appQueryMobile != null && !appQueryMobile.trim().isEmpty() ? appQueryMobile : appQuery;

        List<App> apps = appService.findAll().stream()
                .filter(app -> app.getName().toLowerCase().contains(query.toLowerCase()) || app.getDescription().toLowerCase().contains(query.toLowerCase()))
                .distinct().toList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("apps.html");
        modelAndView.addObject("apps", apps);
        return modelAndView;
    }
}