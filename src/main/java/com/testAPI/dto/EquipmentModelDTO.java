package com.testAPI.dto;

import com.testAPI.domain.EquipmentModel;

import java.io.Serializable;

public class EquipmentModelDTO implements Serializable {

    private Long id;
    private String name;

    public EquipmentModelDTO() {
    }

    public EquipmentModelDTO(EquipmentModel equipmentModel) {

        id = equipmentModel.getId();
        name = equipmentModel.getName();
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
}
