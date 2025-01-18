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
    private String sensorValue;
    private LocalDateTime measurementTime;

    public DinosaurSensorData() {
    }

    public DinosaurSensorData(String dinosaurId, String sensorType, String sensorValue, LocalDateTime measurementTime) {
        this.dinosaurId = dinosaurId;
        this.sensorType = sensorType;
        this.sensorValue = sensorValue;
        this.measurementTime = measurementTime;
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

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String value) {
        this.sensorValue = value;
    }

    public LocalDateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalDateTime timestamp) {
        this.measurementTime = timestamp;
    }
}

