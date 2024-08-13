package com.watchLog.watchLog.service;

import com.watchLog.watchLog.entity.Shows;
import com.watchLog.watchLog.entity.WatchedShowList;
import com.watchLog.watchLog.repository.WatchedShowListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchedShowListService {

    @Autowired
    private WatchedShowListRepository watchedShows;

    public void saveWatchedShows(WatchedShowList shows) {
        watchedShows.save(shows);
    }

    public List<WatchedShowList> getAllWatchedShows() {
        return watchedShows.findAll();
    }

    public WatchedShowList getShowsById(int id) {
        return watchedShows.findById(id).get();
    }

    public void deleteById(int id) {
        watchedShows.deleteById(id);
    }
}
