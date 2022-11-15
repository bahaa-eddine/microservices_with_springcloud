package com.example.servicecompany;

import com.example.servicecompany.entities.Company;
import com.example.servicecompany.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class ServiceCompanyApplication implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServiceCompanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Tesla","Space X").forEach(companyName -> {
            companyRepository.save(new Company(null,companyName, Math.random()*100));
        });
        companyRepository.findAll().forEach(System.out::println);
    }
}
