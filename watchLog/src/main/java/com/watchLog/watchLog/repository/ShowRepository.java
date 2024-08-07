package com.watchLog.watchLog.repository;

import com.watchLog.watchLog.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Shows, Integer> {
}
