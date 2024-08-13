package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.entity.WatchedShowList;
import com.watchLog.watchLog.service.DroppedShowService;
import com.watchLog.watchLog.service.WatchedShowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DroppedShowListController {

    @Autowired
    private DroppedShowService service;

    @Autowired
    private WatchedShowListService watchedShowService;

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
}
