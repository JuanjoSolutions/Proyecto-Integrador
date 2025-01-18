package com.integral.proyectointegrador.mars.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mars_sensor_data")
public class MarsSensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorName;
    private Double sensorValue;
    private LocalDateTime measurementTime;

    public MarsSensorData() {
    }

    public MarsSensorData(String sensorName, Double sensorValue, LocalDateTime measurementTime) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
        this.measurementTime = measurementTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public LocalDateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalDateTime measurementTime) {
        this.measurementTime = measurementTime;
    }
}

