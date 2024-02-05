package fr.yncrea.maxresadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "fr.yncrea")
@EnableScheduling
public class MaxResAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxResAdapterApplication.class, args);
	}

}
