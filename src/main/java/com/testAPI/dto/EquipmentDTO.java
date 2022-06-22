package com.testAPI.dto;

import com.testAPI.domain.Equipment;

import java.io.Serializable;

public class EquipmentDTO implements Serializable {

    private Long id;
    private String name;
    private Long equipmentModel;

    public EquipmentDTO(Equipment equipment) {
        id = equipment.getId();
        name = equipment.getName();
        equipmentModel = equipment.getEquipmentModel().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(Long equipmentModel) {
        this.equipmentModel = equipmentModel;
    }
}
