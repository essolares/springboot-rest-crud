package com.essolares.demo.student;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig{

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){ 
        return args -> {
            Student a = new Student(
                "User",LocalDate. of(1980,Month.APRIL,5),"ed@gmail.com");
            Student b = new Student(
                "User2",LocalDate. of(1980,Month.APRIL,5),"ed@gmail.com");
            repository.saveAll(List.of(a,b));
        }; 
    }
}