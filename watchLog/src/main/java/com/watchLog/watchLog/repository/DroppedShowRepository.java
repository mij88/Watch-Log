package com.watchLog.watchLog.repository;

import com.watchLog.watchLog.entity.DroppedShowList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroppedShowRepository extends JpaRepository<DroppedShowList, Integer> {
}
