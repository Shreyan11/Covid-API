package com.example.coviddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoviddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoviddemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(CountryRepo repository){
		return args -> {
			Country = new Country(
				restrictions = "None";
				school = "Open";
				transit = "Open";
			);

			// Query q= new Query();
			// q.addCriteria(Criteria.where(school))
			// repository.insert(country);
		}
	}
}
