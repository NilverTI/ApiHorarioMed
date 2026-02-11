package com.tantalean.apihorariomed.config;

import com.tantalean.apihorariomed.model.Schedule;
import com.tantalean.apihorariomed.repository.ScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class SeedData {

    @Bean
    CommandLineRunner init(ScheduleRepository repo) {
        return args -> {
            if (repo.count() == 0) {

                Schedule s1 = new Schedule();
                s1.setNombre("Vitamina C");
                s1.setDosis("1 tableta");
                s1.setHora(LocalTime.of(8, 0));
                s1.setFrecuencia("Diario");
                s1.setNotas("Con comida");
                s1.setActivo(true);

                repo.save(s1);
            }
        };
    }
}
