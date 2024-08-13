package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.entity.PausedShow;
import com.watchLog.watchLog.entity.WatchedShowList;
import com.watchLog.watchLog.service.DroppedShowService;
import com.watchLog.watchLog.service.PausedShowService;
import com.watchLog.watchLog.service.WatchedShowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PausedShowListController {

    @Autowired
    private PausedShowService service;

    @Autowired
    private WatchedShowListService watchedShowService;

    @Autowired
    private DroppedShowService droppedShowService;

    @GetMapping("/paused_shows")
    public String PausedShow(Model model) {
        List<PausedShow> list = service.getAllPausedShows();
        model.addAttribute("shows", list);
        return "pausedShow";
    }

    @PostMapping("/savePausedShow")
    public String addPausedShow(@ModelAttribute PausedShow ps) {
        service.savePausedShows(ps);
        return "redirect:/paused_shows";
    }


    @RequestMapping("/movePausedToCurrentShow/{id}")
    public String restoreCurrentShow(@PathVariable("id") int id) {
        PausedShow ps = service.getShowsById(id);

        WatchedShowList ws = new WatchedShowList(ps.getId(), ps.getName(), ps.getDate(), ps.getGenre(), ps.getSeason(), ps.getEpisode());
        watchedShowService.saveWatchedShows(ws);
        service.deleteById(id);

        return "redirect:/paused_shows";

    }

    @RequestMapping("/movePausedToDroppedShow/{id}")
    public String moveToDroppedShow(@PathVariable("id") int id) {
        PausedShow ps = service.getShowsById(id);

        DroppedShowList ds = new DroppedShowList(ps.getId(), ps.getName(), ps.getDate(), ps.getGenre(), ps.getSeason(), ps.getEpisode());
        droppedShowService.saveDroppedShows(ds);
        service.deleteById(id);
        return "redirect:/paused_shows";
    }

    @RequestMapping("/deletePausedShow/{id}")
    public String deletePausedShow(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/paused_shows";
    }

    @RequestMapping("/editPausedShow/{id}")
    public String editShow(@PathVariable("id") int id, Model model) {
        PausedShow ps = service.getShowsById(id);
        model.addAttribute("shows", ps);
        return "PausedShowEdit";
    }


}
