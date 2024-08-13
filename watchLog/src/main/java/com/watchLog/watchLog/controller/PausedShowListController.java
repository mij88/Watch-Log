package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.entity.PausedShow;
import com.watchLog.watchLog.service.DroppedShowService;
import com.watchLog.watchLog.service.PausedShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PausedShowListController {

    @Autowired
    private PausedShowService service;

    @GetMapping("/paused_shows")
    public String PausedShow(Model model) {
        List<PausedShow> list = service.getAllPausedShows();
        model.addAttribute("shows", list);
        return "pausedShow";
    }
}
