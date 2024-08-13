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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
