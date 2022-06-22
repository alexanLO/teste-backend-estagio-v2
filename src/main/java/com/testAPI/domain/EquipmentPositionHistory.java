package com.testAPI.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "equipment_position_history")
public class EquipmentPositionHistory implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private Date date;
    private Double lat;
    private Double lon;

    public EquipmentPositionHistory() {
    }

    public EquipmentPositionHistory(Long id, Date date, Double lat, Double lon) {
        this.id = id;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentPositionHistory that = (EquipmentPositionHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
