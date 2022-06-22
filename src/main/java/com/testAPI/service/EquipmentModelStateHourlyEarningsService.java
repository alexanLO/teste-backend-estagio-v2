package com.testAPI.service;

import com.testAPI.domain.EquipmentModelStateHourlyEarnings;
import com.testAPI.dto.EquipmentModelStateHourlyEarningsDTO;
import com.testAPI.exception.ObjectNotFoundException;
import com.testAPI.repository.EquipmentModelStateHourlyEarningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipmentModelStateHourlyEarningsService {

    @Autowired
    private EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

    //GET
    public List<EquipmentModelStateHourlyEarnings> findAllEquipmentModelStateHourlyEarnings() {
        return equipmentModelStateHourlyEarningsRepository.findAll();
    }

    //GET BY ID
    public EquipmentModelStateHourlyEarnings findEquipmentModelStateHourlyEarningsByID(Long id) {
        return equipmentModelStateHourlyEarningsRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Informações não encontradas!"));
    }

    //POST
    public EquipmentModelStateHourlyEarnings createEquipmentModelStateHourlyEarnings(EquipmentModelStateHourlyEarnings EquipmentModelStateHourlyEarnings) {
        return equipmentModelStateHourlyEarningsRepository.save(EquipmentModelStateHourlyEarnings);
    }

    //DELETE
    public void delete(Long id) {
        equipmentModelStateHourlyEarningsRepository.delete(findEquipmentModelStateHourlyEarningsByID(id));
    }

    //PULL
    public EquipmentModelStateHourlyEarnings updateEquipmentModelStateHourlyEarnings(EquipmentModelStateHourlyEarnings EquipmentModelStateHourlyEarnings) {
        EquipmentModelStateHourlyEarnings newEquipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsRepository.findById(EquipmentModelStateHourlyEarnings.getId()).orElseThrow(() -> new ObjectNotFoundException("Modelo de equipamento não encontrado!"));
        updateData(newEquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarnings);
        return equipmentModelStateHourlyEarningsRepository.save(newEquipmentModelStateHourlyEarnings);
    }

    private void updateData(EquipmentModelStateHourlyEarnings newEquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings) {
        newEquipmentModelStateHourlyEarnings.setEquipmentModel(equipmentModelStateHourlyEarnings.getEquipmentModel());
        newEquipmentModelStateHourlyEarnings.setEquipmentState(equipmentModelStateHourlyEarnings.getEquipmentState());
        newEquipmentModelStateHourlyEarnings.setValue(equipmentModelStateHourlyEarnings.getValue());
    }

    public EquipmentModelStateHourlyEarnings fromDTO(EquipmentModelStateHourlyEarningsDTO equipmentModelStateHourlyEarningsDTO) {
        return new EquipmentModelStateHourlyEarnings(equipmentModelStateHourlyEarningsDTO.getId(), equipmentModelStateHourlyEarningsDTO.getEquipmentModel(), equipmentModelStateHourlyEarningsDTO.getEquipmentState(), equipmentModelStateHourlyEarningsDTO.getValue());
    }
}
