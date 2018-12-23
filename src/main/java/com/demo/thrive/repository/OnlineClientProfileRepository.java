package com.demo.thrive.repository;

import com.demo.thrive.model.OnlineClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineClientProfileRepository extends JpaRepository<OnlineClientProfile, Long> {

    OnlineClientProfile findByClientId(Long clientId);
}
