package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.Shows;
import com.watchLog.watchLog.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShowController {

    @Autowired
    private ShowService service;

    @GetMapping
    public String home() { return "home";}

    @GetMapping("/show_register")
    public String showRegister() {return "showRegister";}

    @GetMapping("/show_list")
    public String showList() {return "showList";}

    @PostMapping("/save")
    public String addShow(@ModelAttribute Shows s) {
        service.save(s);
        return "redirect:/show_list";
    }
}
