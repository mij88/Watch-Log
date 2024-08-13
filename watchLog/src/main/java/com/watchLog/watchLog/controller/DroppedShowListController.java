package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.entity.WatchedShowList;
import com.watchLog.watchLog.service.DroppedShowService;
import com.watchLog.watchLog.service.WatchedShowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DroppedShowListController {

    @Autowired
    private DroppedShowService service;

    @Autowired
    private WatchedShowListService watchedShowService;

    @PostMapping("/saveDroppedShow")
    public String addDroppedShow(@ModelAttribute DroppedShowList ds) {
        service.saveDroppedShows(ds);
        return "redirect:/dropped_shows";
    }

    @GetMapping("/dropped_shows")
    public String droppedShow(Model model) {
        List<DroppedShowList> list = service.getAllDroppedShows();
        model.addAttribute("shows", list);
        return "droppedShow";
    }

    @RequestMapping("/deleteDroppedShow/{id}")
    public String deleteDroppedShow(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/dropped_shows";
    }

    @RequestMapping("/MoveDroppedToCurrentShow/{id}")
    public String restoreCurrentShow(@PathVariable("id") int id) {
        DroppedShowList ds = service.getShowsById(id);

        WatchedShowList ws = new WatchedShowList(ds.getId(), ds.getName(), ds.getDate(), ds.getGenre(), ds.getSeason(), ds.getEpisode());
        watchedShowService.saveWatchedShows(ws);
        service.deleteById(id);

       return "redirect:/dropped_shows";

    }

    @RequestMapping("/editDroppedShow/{id}")
    public String editShow(@PathVariable("id") int id, Model model) {
        DroppedShowList ds = service.getShowsById(id);
        model.addAttribute("shows", ds);
        return "DroppedShowEdit";
    }
}
