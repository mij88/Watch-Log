package com.watchLog.watchLog.repository;

import com.watchLog.watchLog.entity.WatchedShowList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchedShowListRepository extends JpaRepository <WatchedShowList, Integer> {
}
