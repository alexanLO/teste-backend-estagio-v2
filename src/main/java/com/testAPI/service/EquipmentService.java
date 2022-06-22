package com.testAPI.service;

import com.testAPI.domain.Equipment;
import com.testAPI.dto.EquipmentDTO;
import com.testAPI.exception.ObjectNotFoundException;
import com.testAPI.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    //GET
    public List<Equipment> findAllEquipments() {
        return equipmentRepository.findAll();
    }

    //GET BY ID
    public Equipment findEquipmentByID(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Equipamento não encontrado!"));
    }

    //POST
    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    //DELETE
    public void delete(Long id) {
        equipmentRepository.delete(findEquipmentByID(id));
    }

    //PULL
    public Equipment updateEquipment(Equipment equipment) {
        Equipment newEquipment = equipmentRepository.findById(equipment.getId()).orElseThrow(() -> new ObjectNotFoundException("Equipamento não encontrado!"));
        updateData(newEquipment, equipment);
        return equipmentRepository.save(newEquipment);
    }

    private void updateData(Equipment newEquipment, Equipment equipment) {
        newEquipment.setName(equipment.getName());
    }

    public Equipment fromDTO(EquipmentDTO equipmentDTO) {
        return new Equipment(equipmentDTO.getId(), equipmentDTO.getName());
    }
}
