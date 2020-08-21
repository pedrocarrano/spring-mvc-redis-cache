package br.com.pgcarr.springredis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String execute() {
        return "hello";
    }
}
