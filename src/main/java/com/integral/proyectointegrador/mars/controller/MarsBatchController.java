package com.integral.proyectointegrador.mars.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mars/batch")
public class MarsBatchController {
    private final JobLauncher jobLauncher;
    private final Job marsDataJob;

    public MarsBatchController(JobLauncher jobLauncher, Job marsDataJob) {
        this.jobLauncher = jobLauncher;
        this.marsDataJob = marsDataJob;
    }

    @PostMapping("/process")
    public ResponseEntity<String> launchJob() {
        try {
            JobExecution execution = jobLauncher.run(marsDataJob,
                    new JobParametersBuilder()
                            .addLong("time", System.currentTimeMillis())
                            .toJobParameters());
            return ResponseEntity.ok("Job iniciado: " + execution.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}

