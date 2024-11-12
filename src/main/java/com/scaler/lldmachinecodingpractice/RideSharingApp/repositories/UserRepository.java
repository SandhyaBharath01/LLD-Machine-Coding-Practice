package com.scaler.lldmachinecodingpractice.RideSharingApp.repositories;

import com.scaler.lldmachinecodingpractice.RideSharingApp.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Driver, Integer> {
    Optional<Driver> findById(int driverId);
}
