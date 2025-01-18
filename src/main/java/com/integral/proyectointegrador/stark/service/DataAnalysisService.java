package com.integral.proyectointegrador.stark.service;

import com.integral.proyectointegrador.stark.model.RawDataRecord;
import com.integral.proyectointegrador.stark.repository.RawDataRepository;
import org.springframework.stereotype.Service;

//import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class DataAnalysisService {
    private final RawDataRepository rawDataRepository;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final AtomicInteger processedCount = new AtomicInteger(0);

    public DataAnalysisService(RawDataRepository rawDataRepository) {
        this.rawDataRepository = rawDataRepository;
    }

    public void processBatch(List<Long> rawDataIds) {
        for (Long id : rawDataIds) {
            executorService.submit(() -> processSingleRecord(id));
        }
    }

    private void processSingleRecord(Long rawDataId) {
        RawDataRecord rawData = rawDataRepository.findById(rawDataId)
                .orElseThrow(() -> new RuntimeException("Data not found"));
        // Logica de análisis...
        processedCount.incrementAndGet();
    }

    public int getTotalProcessed() {
        return processedCount.get();
    }

//    @PreDestroy
//    public void shutdownExecutor() {
//        executorService.shutdown();
//    }
}

