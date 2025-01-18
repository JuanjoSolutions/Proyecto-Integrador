package com.integral.proyectointegrador.gotham.service;

import com.integral.proyectointegrador.gotham.model.SecurityLog;
import com.integral.proyectointegrador.gotham.repository.SecurityLogRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SecurityService {
    private final SecurityLogRepository securityLogRepository;
    public SecurityService(SecurityLogRepository securityLogRepository) {
        this.securityLogRepository = securityLogRepository;
    }
    public void logSecurityEvent(String username, String action) {
        SecurityLog log = new SecurityLog(username, action, LocalDateTime.now());
        securityLogRepository.save(log);
    }
    public List<SecurityLog> findAllLogs() {
        return securityLogRepository.findAll();
    }
}

