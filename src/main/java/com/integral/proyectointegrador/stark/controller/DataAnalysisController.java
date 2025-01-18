package com.integral.proyectointegrador.stark.controller;

import com.integral.proyectointegrador.stark.model.RawDataRecord;
import com.integral.proyectointegrador.stark.repository.RawDataRepository;
import com.integral.proyectointegrador.stark.service.DataAnalysisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/stark/data")
public class DataAnalysisController {
    private final RawDataRepository rawDataRepository;
    private final DataAnalysisService dataAnalysisService;

    public DataAnalysisController(RawDataRepository rawDataRepository,
                                  DataAnalysisService dataAnalysisService) {
        this.rawDataRepository = rawDataRepository;
        this.dataAnalysisService = dataAnalysisService;
    }

    @PostMapping("/raw")
    public ResponseEntity<RawDataRecord> createRawData(@RequestBody RawDataRecord rawData) {
        rawData.setReceivedAt(LocalDateTime.now());
        RawDataRecord saved = rawDataRepository.save(rawData);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/process")
    public ResponseEntity<String> processData(@RequestBody List<Long> ids) {
        dataAnalysisService.processBatch(ids);
        return ResponseEntity.ok("Data processing initiated.");
    }

    @GetMapping("/processed-count")
    public ResponseEntity<Integer> getProcessedCount() {
        return ResponseEntity.ok(dataAnalysisService.getTotalProcessed());
    }
}

