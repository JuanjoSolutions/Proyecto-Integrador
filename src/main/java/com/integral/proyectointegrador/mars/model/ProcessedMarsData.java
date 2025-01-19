package com.integral.proyectointegrador.mars.model;

import java.time.LocalDateTime;

public class ProcessedMarsData {

    private Long id;
    private String sensorName;
    private Double transformedValue;
    private LocalDateTime measurementTime;

    // Constructor(s)
    public ProcessedMarsData() {
    }

    public ProcessedMarsData(Long id, String sensorName, Double transformedValue, LocalDateTime measurementTime) {
        this.id = id;
        this.sensorName = sensorName;
        this.transformedValue = transformedValue;
        this.measurementTime = measurementTime;
    }

    // Getters y setters
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

    public Double getTransformedValue() {
        return transformedValue;
    }

    public void setTransformedValue(Double transformedValue) {
        this.transformedValue = transformedValue;
    }

    public LocalDateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalDateTime measurementTime) {
        this.measurementTime = measurementTime;
    }

    @Override
    public String toString() {
        return "ProcessedMarsData{" +
                "id=" + id +
                ", sensorName='" + sensorName + '\'' +
                ", transformedValue=" + transformedValue +
                ", measurementTime=" + measurementTime +
                '}';
    }
}

