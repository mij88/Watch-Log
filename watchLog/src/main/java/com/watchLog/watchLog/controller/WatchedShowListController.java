package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.service.WatchedShowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WatchedShowListController {

    @Autowired
    private WatchedShowListService service;

    @RequestMapping("/deleteWatchedShow/{id}")
    public String deleteWatchedShow(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/watched_shows";
    }

}
