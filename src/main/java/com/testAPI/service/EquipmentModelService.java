package com.testAPI.service;

import com.testAPI.domain.EquipmentModel;
import com.testAPI.dto.EquipmentModelDTO;
import com.testAPI.exception.ObjectNotFoundException;
import com.testAPI.repository.EquipmentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentModelService {

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    //GET
    public List<EquipmentModel> findAllModels() {
        return equipmentModelRepository.findAll();
    }

    //GET BY ID
    public EquipmentModel findModelByID(Long id) {
        return equipmentModelRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Modelo não encontrado!"));
    }

    //POST
    public EquipmentModel createEquipmentModel(EquipmentModel equipmentModel) {
        return equipmentModelRepository.save(equipmentModel);
    }

    //DELETE
    public void deleteModel(Long id) {
        equipmentModelRepository.delete(findModelByID(id));
    }

    //PULL
    public EquipmentModel updateModel(EquipmentModel equipmentModel) {
        EquipmentModel newEquipmentModel = equipmentModelRepository.findById(equipmentModel.getId()).orElseThrow(() -> new ObjectNotFoundException("Modelo de equipamento não encontrado!"));
        updateData(newEquipmentModel, equipmentModel);
        return equipmentModelRepository.save(newEquipmentModel);
    }

    private void updateData(EquipmentModel newEquipmentModel, EquipmentModel equipmentModel) {
        newEquipmentModel.setName(equipmentModel.getName());
    }

    public EquipmentModel fromDTO(EquipmentModelDTO equipmentModelDTO) {
        return new EquipmentModel(equipmentModelDTO.getId(), equipmentModelDTO.getName());
    }
}
