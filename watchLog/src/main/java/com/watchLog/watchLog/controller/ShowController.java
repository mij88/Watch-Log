package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.Shows;
import com.watchLog.watchLog.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShowController {

    @Autowired
    private ShowService service;

    @GetMapping
    public String home() { return "home";}

    @GetMapping("/show_register")
    public String showRegister() {return "showRegister";}

    @GetMapping("/show_list")
    public ModelAndView showList() {
        List<Shows> list = service.getAllShows();

        return new ModelAndView("showList", "shows", list);
    }

    @PostMapping("/save")
    public String addShow(@ModelAttribute Shows s) {
        service.save(s);
        return "redirect:/show_list";
    }
}
