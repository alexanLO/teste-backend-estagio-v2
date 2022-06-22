package com.testAPI.dto;

import com.testAPI.domain.EquipmentState;

import java.io.Serializable;

public class EquipmentStateDTO implements Serializable {

    private Long id;
    private String name;
    private String color;

    public EquipmentStateDTO(EquipmentState equipmentState) {
        id = equipmentState.getId();
        name = equipmentState.getName();
        color = equipmentState.getColor();
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
