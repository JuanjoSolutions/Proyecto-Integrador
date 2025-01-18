package com.integral.proyectointegrador.jurassic.service;

import com.integral.proyectointegrador.jurassic.model.DinosaurSensorData;
import com.integral.proyectointegrador.jurassic.repository.DinosaurSensorDataRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DinosaurSensorService {
    private final DinosaurSensorDataRepository repository;

    public DinosaurSensorService(DinosaurSensorDataRepository repository) {
        this.repository = repository;
    }

    public Mono<DinosaurSensorData> saveSensorData(DinosaurSensorData data) {
        return Mono.fromCallable(() -> {
            data.setTimestamp(LocalDateTime.now());
            return repository.save(data);
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Flux<DinosaurSensorData> getSensorDataByDinosaurId(String dinosaurId) {
        return Flux.defer(() -> {
            List<DinosaurSensorData> list = repository.findByDinosaurId(dinosaurId);
            return Flux.fromIterable(list);
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Flux<DinosaurSensorData> getAllSensorData() {
        return Flux.defer(() -> {
            List<DinosaurSensorData> list = repository.findAll();
            return Flux.fromIterable(list);
        }).subscribeOn(Schedulers.boundedElastic());
    }
}

