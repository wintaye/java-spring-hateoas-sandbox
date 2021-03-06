package org.wintaye.org.payroll.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wintaye.org.payroll.models.datamodels.EmployeeRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief")));
            log.info("Preloading " + repository.save(new Employee("Samwise", "Gamgee", "best friend")));
            log.info("Preloading " + repository.save(new Employee("Minnie", "Mouse", "sex symbol")));
            log.info("Preloading " + repository.save(new Employee("Mickey", "Mouse", "heartthrob")));
        };
    }
}
