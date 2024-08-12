package com.watchLog.watchLog.service;

import com.watchLog.watchLog.entity.DroppedShowList;
import com.watchLog.watchLog.repository.DroppedShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroppedShowService {

    @Autowired
    private DroppedShowRepository droppedShows;

    public void saveDroppedShows(DroppedShowList show) {
        droppedShows.save(show);
    }

    public List<DroppedShowList> getDroppedShows() {
        return droppedShows.findAll();
    }

    public void deleteById(int id) {
        droppedShows.deleteById(id);
    }


}
