package com.docsbymario.root.controller;

import com.docsbymario.root.entity.App;
import com.docsbymario.root.service.AppService;
import com.docsbymario.root.util.StringUtils;
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
        String query = processQuery(appQuery, appQueryMobile);

        List<App> apps = appService.findAll().stream()
                .filter(app -> app.getName().toLowerCase().contains(query) || app.getDescription().toLowerCase().contains(query.toLowerCase()))
                .distinct().toList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("apps.html");
        modelAndView.addObject("apps", apps);
        return modelAndView;
    }

    private String processQuery(String appQuery, String appQueryMobile) {
        String result = !StringUtils.isEmpty(appQueryMobile) ? appQueryMobile :
                !StringUtils.isEmpty(appQuery) ? appQuery : "";

        return result.trim().toLowerCase();
    }
}