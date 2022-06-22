package com.testAPI.repository;

import com.testAPI.domain.EquipmentStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, Long> {
}
