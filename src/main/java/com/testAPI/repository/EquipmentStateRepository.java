package com.testAPI.repository;

import com.testAPI.domain.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentState, Long> {
}
