package com.watchLog.watchLog.controller;

import com.watchLog.watchLog.entity.Shows;
import com.watchLog.watchLog.entity.WatchedShowList;
import com.watchLog.watchLog.service.ShowService;
import com.watchLog.watchLog.service.WatchedShowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShowController {

    @Autowired
    private ShowService service;

    @Autowired
    private WatchedShowListService watchedShowListService;

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

    @GetMapping("/watched_shows")
    public String watchedShow(Model model) {
        List<WatchedShowList> list = watchedShowListService.getAllWatchedShows();
        model.addAttribute("shows", list);
        return "watchedShow";
    }

    @RequestMapping("/watchedList/{id}")
    public String getWatchedList(@PathVariable("id") int id) {
        Shows s = service.getShowsById(id);

        WatchedShowList ws = new WatchedShowList(s.getId(), s.getName(), s.getDate(), s.getGenre(), "1", "0");
        watchedShowListService.saveWatchedShows(ws);
        service.deleteById(id);
        return "redirect:/watched_shows";
    }


    @RequestMapping("/editShow/{id}")
    public String editShow(@PathVariable("id") int id, Model model) {
        Shows s = service.getShowsById(id);
        model.addAttribute("shows", s);
        return "showEdit";
    }

    @RequestMapping("/deleteShow/{id}")
    public String deleteShow(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/show_list";
    }


}
