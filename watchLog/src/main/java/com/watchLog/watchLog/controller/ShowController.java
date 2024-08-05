package com.watchLog.watchLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {


    @GetMapping
    public String home() {
        return "home";
    }
}
