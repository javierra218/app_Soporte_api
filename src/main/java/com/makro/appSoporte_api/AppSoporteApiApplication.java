// package com.makro.appSoporte_api;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class AppSoporteApiApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(AppSoporteApiApplication.class, args);
// 	}

// }


package com.makro.appSoporte_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.makro.appsoporte_api.repository")
@ComponentScan(basePackages = "com.makro.appsoporte_api")
@EntityScan(basePackages = "com.makro.appsoporte_api.model")
public class AppSoporteApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppSoporteApiApplication.class, args);
    }
}

