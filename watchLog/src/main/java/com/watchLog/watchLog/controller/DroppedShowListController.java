package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.service.DroppedShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DroppedShowListController {

    @Autowired
    private DroppedShowService service;

    @RequestMapping("/deleteDroppedShow/{id}")
    public String deleteDroppedShow(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/dropped_shows";
    }
}
