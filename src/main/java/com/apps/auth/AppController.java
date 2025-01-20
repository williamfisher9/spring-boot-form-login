package com.apps.auth;

import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(){
        return "home page";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String getError(){
        return "error page";
    }
}
