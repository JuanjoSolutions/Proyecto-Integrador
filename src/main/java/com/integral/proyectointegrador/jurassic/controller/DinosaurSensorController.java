package com.integral.proyectointegrador.jurassic.controller;

import com.integral.proyectointegrador.jurassic.model.DinosaurSensorData;
import com.integral.proyectointegrador.jurassic.service.DinosaurSensorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/jurassic")
public class DinosaurSensorController {
    private final DinosaurSensorService sensorService;

    public DinosaurSensorController(DinosaurSensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/sensor-data")
    public Mono<DinosaurSensorData> ingestSensorData(@RequestBody DinosaurSensorData data) {
        return sensorService.saveSensorData(data);
    }

    @GetMapping("/sensor-data/{dinoId}")
    public Flux<DinosaurSensorData> getSensorData(@PathVariable String dinoId) {
        return sensorService.getSensorDataByDinosaurId(dinoId);
    }

    @GetMapping(value = "/sensor-data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<DinosaurSensorData> streamAllSensorData() {
        return sensorService.getAllSensorData();
    }
}

