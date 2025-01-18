package com.integral.proyectointegrador.magic.circuitbreaker;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplateBuilder;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MagicIntegrationService {
    private final RestTemplate restTemplate;

    public MagicIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    public MagicIntegrationService(RestTemplateBuilder builder) {
//
//        this.restTemplate = builder.build();
//    }

    @CircuitBreaker(name = "starkBreaker", fallbackMethod = "fallbackResponse")
    public String getStarkResource() {
        return restTemplate.getForObject("http://localhost:8080/api/stark/data/health", String.class);
    }

    public String fallbackResponse(Throwable t) {
        return "Stark Industries no disponible. Respuesta de fallback.";
    }
}

