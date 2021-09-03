package org.exercises.service_layer.controllers;

import org.apache.catalina.connector.InputBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

@Controller
public class ListOfPages {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";


    }
}
