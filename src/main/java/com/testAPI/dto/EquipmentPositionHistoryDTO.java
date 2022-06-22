package com.testAPI.dto;

import com.testAPI.domain.EquipmentPositionHistory;

import java.io.Serializable;
import java.util.Date;


public class EquipmentPositionHistoryDTO implements Serializable {

    private Long id;
    private Date date;
    private Double lat;
    private Double lon;

    public EquipmentPositionHistoryDTO() {
    }

    public EquipmentPositionHistoryDTO(EquipmentPositionHistory equipmentPositionHistory) {
        id = equipmentPositionHistory.getId();
        date = equipmentPositionHistory.getDate();
        lat = equipmentPositionHistory.getLat();
        lon = equipmentPositionHistory.getLon();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
