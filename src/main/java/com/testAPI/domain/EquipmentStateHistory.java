package com.testAPI.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState equipmentState;

    private Date date;

    public EquipmentStateHistory() {
    }

    public EquipmentStateHistory(Date date, Equipment equipment, EquipmentState equipmentState) {
    }

    public EquipmentStateHistory(Long id, Equipment equipment, EquipmentState equipmentState, Date date) {
        this.id = id;
        this.equipment = equipment;
        this.equipmentState = equipmentState;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentStateHistory that = (EquipmentStateHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
