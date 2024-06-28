package com.makro.appSoporte_api.config;

import com.makro.appSoporte_api.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {
    @Autowired
    private TrabajadorService trabajadorService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void resetPesosAcumulados() {
        trabajadorService.resetPesosAcumulados();
    }
}