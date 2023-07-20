package be.bxlforma.api;

import be.bxlforma.api.service.StringService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

	// doit s'utiliser
	// 1 - sur une méthode
	// 2 - d'une classe annotée de @SpringBootApplication ou @Configuration
	@Bean
	public StringService stringService2(){
		return new StringService();
	}

}
