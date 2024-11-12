package com.scaler.lldmachinecodingpractice.RideSharingApp.repositories;

import com.scaler.lldmachinecodingpractice.TaskManagementSystem.models.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(int userId);
}
