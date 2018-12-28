package com.demo.thrive.repository;

import com.demo.thrive.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

     List<Activity> findByTrainers_TrainerId(Long trainerID);
}
