package org.exercises.service_layer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListOfPages {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("home");
    }
}
