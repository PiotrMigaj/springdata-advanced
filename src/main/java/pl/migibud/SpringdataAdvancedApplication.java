package pl.migibud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringdataAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataAdvancedApplication.class, args);
	}


}
