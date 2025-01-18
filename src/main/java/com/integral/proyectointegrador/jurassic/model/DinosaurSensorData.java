package com.integral.proyectointegrador.jurassic.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dinosaur_sensor_data")
public class DinosaurSensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dinosaurId;
    private String sensorType;
    private String value;
    private LocalDateTime timestamp;

    public DinosaurSensorData() {
    }

    public DinosaurSensorData(String dinosaurId, String sensorType, String value, LocalDateTime timestamp) {
        this.dinosaurId = dinosaurId;
        this.sensorType = sensorType;
        this.value = value;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDinosaurId() {
        return dinosaurId;
    }

    public void setDinosaurId(String dinosaurId) {
        this.dinosaurId = dinosaurId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

