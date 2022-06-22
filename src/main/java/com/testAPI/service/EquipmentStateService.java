package com.testAPI.service;

import com.testAPI.domain.EquipmentState;
import com.testAPI.dto.EquipmentStateDTO;
import com.testAPI.exception.ObjectNotFoundException;
import com.testAPI.repository.EquipmentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipmentStateService {

    @Autowired
    private EquipmentStateRepository equipmentStateRepository;

    //GET
    public List<EquipmentState> findAllEquipmentStates() {
        return equipmentStateRepository.findAll();
    }

    //GET BY ID
    public EquipmentState findEquipmentStateByID(Long id) {
        return equipmentStateRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Estado do equipamento não encontrado!"));
    }

    //POST
    public EquipmentState createEquipmentState(EquipmentState equipmentState) {
        return equipmentStateRepository.save(equipmentState);
    }

    //DELETE
    public void delete(Long id) {
        equipmentStateRepository.delete(findEquipmentStateByID(id));
    }

    //PULL
    public EquipmentState updateEquipmentState(EquipmentState equipmentState) {
        EquipmentState newEquipmentState = equipmentStateRepository.findById(equipmentState.getId()).orElseThrow(() -> new ObjectNotFoundException("Modelo de equipamento não encontrado!"));
        updateData(newEquipmentState, equipmentState);
        return equipmentStateRepository.save(newEquipmentState);
    }

    private void updateData(EquipmentState newEquipmentState, EquipmentState equipmentState) {
        newEquipmentState.setName(equipmentState.getName());
    }

    public EquipmentState fromDTO(EquipmentStateDTO equipmentStateDTO) {
        return new EquipmentState(equipmentStateDTO.getId(), equipmentStateDTO.getName(), equipmentStateDTO.getColor());
    }
}
