package com.watchLog.watchLog.repository;

import com.watchLog.watchLog.entity.PausedShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PausedShowRepository extends JpaRepository <PausedShow, Integer> {
}
