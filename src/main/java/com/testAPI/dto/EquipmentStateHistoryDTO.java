package com.testAPI.dto;

import com.testAPI.domain.Equipment;
import com.testAPI.domain.EquipmentState;
import com.testAPI.domain.EquipmentStateHistory;

import java.io.Serializable;
import java.util.Date;

public class EquipmentStateHistoryDTO implements Serializable {

    private Equipment equipment;
    private EquipmentState equipmentState;
    private Date date;

    public EquipmentStateHistoryDTO() {
    }

    public EquipmentStateHistoryDTO(EquipmentStateHistory equipmentStateHistory) {
        equipment = equipmentStateHistory.getEquipment();
        equipmentState = equipmentStateHistory.getEquipmentState();
        date = equipmentStateHistory.getDate();
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
