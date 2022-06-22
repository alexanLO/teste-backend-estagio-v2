package com.testAPI.service;

import com.testAPI.domain.EquipmentPositionHistory;
import com.testAPI.dto.EquipmentPositionHistoryDTO;
import com.testAPI.exception.ObjectNotFoundException;
import com.testAPI.repository.EquipmentPositionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipmentPositionHistoryService {

    @Autowired
    private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    //GET
    public List<EquipmentPositionHistory> findAllEquipmentPositionHistorys() {
        return equipmentPositionHistoryRepository.findAll();
    }

    //GET BY ID
    public EquipmentPositionHistory findEquipmentPositionHistoryByID(Long id) {
        return equipmentPositionHistoryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Equipamento não encontrado!"));
    }

    //POST
    public EquipmentPositionHistory createEquipmentPositionHistory(EquipmentPositionHistory EquipmentPositionHistory) {
        return equipmentPositionHistoryRepository.save(EquipmentPositionHistory);
    }

    //DELETE
    public void delete(Long id) {
        equipmentPositionHistoryRepository.delete(findEquipmentPositionHistoryByID(id));
    }

    //PULL
    public EquipmentPositionHistory updateEquipmentPositionHistory(EquipmentPositionHistory EquipmentPositionHistory) {
        EquipmentPositionHistory newEquipmentPositionHistory = equipmentPositionHistoryRepository.findById(EquipmentPositionHistory.getId()).orElseThrow(() -> new ObjectNotFoundException("Modelo de equipamento não encontrado!"));
        updateData(newEquipmentPositionHistory, EquipmentPositionHistory);
        return equipmentPositionHistoryRepository.save(newEquipmentPositionHistory);
    }

    private void updateData(EquipmentPositionHistory newEquipmentPositionHistory, EquipmentPositionHistory equipmentPositionHistory) {
        newEquipmentPositionHistory.setDate(equipmentPositionHistory.getDate());
        newEquipmentPositionHistory.setLat(equipmentPositionHistory.getLat());
        newEquipmentPositionHistory.setLon(equipmentPositionHistory.getLon());
    }

    public EquipmentPositionHistory fromDTO(EquipmentPositionHistoryDTO equipmentPositionHistoryDTO) {
        return new EquipmentPositionHistory(equipmentPositionHistoryDTO.getId(), equipmentPositionHistoryDTO.getDate(), equipmentPositionHistoryDTO.getLat(), equipmentPositionHistoryDTO.getLon());
    }
}
