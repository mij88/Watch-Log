package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.entity.Shows;
import com.watchLog.watchLog.entity.WatchedShowList;
import com.watchLog.watchLog.service.DroppedShowService;
import com.watchLog.watchLog.service.WatchedShowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WatchedShowListController {

    @Autowired
    private WatchedShowListService service;

    @Autowired
    private DroppedShowService droppedShowService;

    @PostMapping("/saveWatchedShow")
    public String addWatchedShow(@ModelAttribute WatchedShowList ws) {
        service.saveWatchedShows(ws);
        return "redirect:/watched_shows";
    }

    @GetMapping("/watched_shows")
    public String watchedShow(Model model) {
        List<WatchedShowList> list = service.getAllWatchedShows();
        model.addAttribute("shows", list);
        return "currentShow";
    }

    @RequestMapping("/deleteWatchedShow/{id}")
    public String deleteWatchedShow(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/watched_shows";
    }


    @RequestMapping("/droppedList/{id}")
    public String getDroppedList(@PathVariable("id") int id) {
        WatchedShowList s = service.getShowsById(id);

        DroppedShowList ds = new DroppedShowList(s.getId(), s.getName(), s.getDate(), s.getGenre(), "1", "0");
        droppedShowService.saveDroppedShows(ds);
        service.deleteById(id);
        return "redirect:/watched_shows";
    }

    @RequestMapping("/editWatchedShow/{id}")
    public String editShow(@PathVariable("id") int id, Model model) {
        WatchedShowList ws = service.getShowsById(id);
        model.addAttribute("shows", ws);
        return "currentShowEdit";
    }

}
