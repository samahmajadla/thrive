package com.demo.thrive.repository;

import com.demo.thrive.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s WHERE s.time BETWEEN ?1 AND ?2")
    List<Session> findSessionsBetweenDates(Date start, Date end);

    @Query("SELECT s, t FROM Session s JOIN s.trainer t WHERE s.time BETWEEN ?1 AND ?2 AND t.trainerId LIKE ?3")
    List<Session> findSessionsBetweenDatesAndByTrainer(Date start, Date end, Long trainerId);


    List<Session> findByTrainer_TrainerId(Long trainerId);


}
