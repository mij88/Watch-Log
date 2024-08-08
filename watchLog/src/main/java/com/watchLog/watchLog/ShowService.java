package com.watchLog.watchLog;

import com.watchLog.watchLog.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository sRepo;

}
