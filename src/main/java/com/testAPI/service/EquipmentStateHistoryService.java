package com.testAPI.service;

import com.testAPI.domain.EquipmentStateHistory;
import com.testAPI.dto.EquipmentStateHistoryDTO;
import com.testAPI.exception.ObjectNotFoundException;
import com.testAPI.repository.EquipmentStateHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentStateHistoryService {

    @Autowired
    private EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    //GET
    public List<EquipmentStateHistory> findAllEquipmentStateHistory(){
        return equipmentStateHistoryRepository.findAll();
    }

    //GET BY ID
    public EquipmentStateHistory findEquipmentStateHistoryByID(Long id) {
        return equipmentStateHistoryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Informações não encontrado!"));
    }

    //POST
    public EquipmentStateHistory createEquipmentStateHistory(EquipmentStateHistory equipmentStateHistory) {
        return equipmentStateHistoryRepository.save(equipmentStateHistory);
    }

    //DELETE
    public void delete(Long id) {
        equipmentStateHistoryRepository.delete(findEquipmentStateHistoryByID(id));
    }

    //PULL
    public EquipmentStateHistory updateEquipmentStateHistory(EquipmentStateHistory equipmentStateHistory) {
        EquipmentStateHistory newEquipmentStateHistory = equipmentStateHistoryRepository.findById(equipmentStateHistory.getId()).orElseThrow(() -> new ObjectNotFoundException("Modelo de equipamento não encontrado!"));
        updateData(newEquipmentStateHistory, equipmentStateHistory);
        return equipmentStateHistoryRepository.save(newEquipmentStateHistory);
    }

    private void updateData(EquipmentStateHistory newEquipmentStateHistory, EquipmentStateHistory equipmentStateHistory) {
        newEquipmentStateHistory.setDate(equipmentStateHistory.getDate());
    }

    public EquipmentStateHistory fromDTO(EquipmentStateHistoryDTO equipmentStateHistoryDTO) {
        return new EquipmentStateHistory(equipmentStateHistoryDTO.getDate(), equipmentStateHistoryDTO.getEquipment(), equipmentStateHistoryDTO.getEquipmentState());
    }
}
