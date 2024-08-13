package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.entity.Shows;
import com.watchLog.watchLog.entity.WatchedShowList;
import com.watchLog.watchLog.service.DroppedShowService;
import com.watchLog.watchLog.service.WatchedShowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WatchedShowListController {

    @Autowired
    private WatchedShowListService service;

    @Autowired
    private DroppedShowService droppedShowService;

    @RequestMapping("/deleteWatchedShow/{id}")
    public String deleteWatchedShow(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/watched_shows";
    }

    @GetMapping("/dropped_shows")
    public String droppedShow(Model model) {
        List<DroppedShowList> list = droppedShowService.getAllDroppedShows();
        model.addAttribute("shows", list);
        return "droppedShow";
    }

    @RequestMapping("/droppedList/{id}")
    public String getDroppedList(@PathVariable("id") int id) {
        WatchedShowList s = service.getShowsById(id);

        DroppedShowList ds = new DroppedShowList(s.getId(), s.getName(), s.getDate(), s.getGenre(), "1", "0");
        droppedShowService.saveDroppedShows(ds);
        service.deleteById(id);
        return "redirect:/watched_shows";
    }

}
