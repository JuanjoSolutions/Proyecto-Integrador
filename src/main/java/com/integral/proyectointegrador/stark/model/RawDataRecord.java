package com.integral.proyectointegrador.stark.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "raw_data_record")
public class RawDataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String payload;
    private LocalDateTime receivedAt;

    public RawDataRecord() {
    }

    public RawDataRecord(String source, String payload, LocalDateTime receivedAt) {
        this.source = source;
        this.payload = payload;
        this.receivedAt = receivedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }
}
