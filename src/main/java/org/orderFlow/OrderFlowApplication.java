package org.orderFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.orderFlow.repository")
@EntityScan(basePackages = "org.orderFlow.model")
public class OrderFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFlowApplication.class, args);
	}
}
