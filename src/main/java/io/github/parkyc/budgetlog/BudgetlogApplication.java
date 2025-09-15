package io.github.parkyc.budgetlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BudgetlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetlogApplication.class, args);
	}

}
