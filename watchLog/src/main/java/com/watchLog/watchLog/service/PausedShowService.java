package com.watchLog.watchLog.service;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.entity.PausedShow;
import com.watchLog.watchLog.repository.PausedShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PausedShowService {

    @Autowired
    private PausedShowRepository pausedShows;

    public void savePausedShows(PausedShow show) {
        pausedShows.save(show);
    }

    public List<PausedShow> getAllPausedShows() {
        return pausedShows.findAll();
    }

    public PausedShow getShowsById(int id) {
        return pausedShows.findById(id).get();
    }

    public void deleteById(int id) {
        pausedShows.deleteById(id);
    }
}
