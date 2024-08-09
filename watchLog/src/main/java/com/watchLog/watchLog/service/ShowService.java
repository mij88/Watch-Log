package com.watchLog.watchLog.service;

import com.watchLog.watchLog.entity.Shows;
import com.watchLog.watchLog.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository sRepo;

    public void save(Shows s) {sRepo.save(s);}

}
