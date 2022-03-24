package com.example.ipldashboard;

import com.example.ipldashboard.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class IplDashboardApplication {

	public static void main(String[] args) {

		SpringApplication.run(IplDashboardApplication.class, args);
	}

}
