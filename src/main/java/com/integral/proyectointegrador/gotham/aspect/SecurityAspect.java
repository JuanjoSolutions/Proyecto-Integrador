package com.integral.proyectointegrador.gotham.aspect;

import com.integral.proyectointegrador.gotham.service.SecurityService;
import com.integral.proyectointegrador.gotham.aspect.Monitored;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
@Component
public class SecurityAspect {
    private final SecurityService securityService;
    private final ReentrantLock lock = new ReentrantLock();

    public SecurityAspect(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Pointcut("@annotation(com.integral.proyectointegrador.gotham.aspect.Monitored)")
    public void monitoredMethods() {}

    @Around("monitoredMethods() && @annotation(monitored)")
    public Object aroundMonitoredMethods(ProceedingJoinPoint pjp, Monitored monitored) throws Throwable {
        String actionDesc = monitored.value().isEmpty()
                ? pjp.getSignature().toShortString()
                : monitored.value();
        securityService.logSecurityEvent("Batman", "Ejecuta: " + actionDesc);

        lock.lock();
        try {
            return pjp.proceed();
        } finally {
            lock.unlock();
        }
    }
}

