package com.testAPI.dto;

import com.testAPI.domain.EquipmentModel;
import com.testAPI.domain.EquipmentModelStateHourlyEarnings;
import com.testAPI.domain.EquipmentState;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class EquipmentModelStateHourlyEarningsDTO implements Serializable {

    private Long id;
    private EquipmentModel equipmentModel;
    private EquipmentState equipmentState;
    private Integer value;

    public EquipmentModelStateHourlyEarningsDTO(EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings) {
        id = equipmentModelStateHourlyEarnings.getId();
        equipmentModel = equipmentModelStateHourlyEarnings.getEquipmentModel();
        equipmentState = equipmentModelStateHourlyEarnings.getEquipmentState();
        value = equipmentModelStateHourlyEarnings.getValue();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }
}
