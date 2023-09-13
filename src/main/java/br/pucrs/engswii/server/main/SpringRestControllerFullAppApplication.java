package br.pucrs.engswii.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages= {"br.pucrs.engswii"})
@EnableMongoRepositories
public class SpringRestControllerFullAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestControllerFullAppApplication.class, args);
	}

}
