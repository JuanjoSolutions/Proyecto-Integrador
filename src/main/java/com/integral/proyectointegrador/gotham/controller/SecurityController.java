package com.integral.proyectointegrador.gotham.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.integral.proyectointegrador.gotham.service.SecurityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import com.integral.proyectointegrador.gotham.model.SecurityLog;
import java.util.List;

@RestController
@RequestMapping("/api/gotham/security")
public class SecurityController {
    private final SecurityService securityService;
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }
    @GetMapping("/logs")
    public ResponseEntity<List<SecurityLog>> getAllSecurityLogs() {
        return ResponseEntity.ok(securityService.findAllLogs());
    }
}

