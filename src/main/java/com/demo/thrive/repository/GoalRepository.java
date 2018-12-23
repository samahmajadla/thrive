package com.demo.thrive.repository;

import com.demo.thrive.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    List<Goal> findByClientProfileId(Long clientProfileId);

}
