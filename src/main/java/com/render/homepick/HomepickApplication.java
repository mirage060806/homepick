package com.render.homepick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // DB 자동 설정 제외
@RestController
public class HomepickApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomepickApplication.class, args);
	}

	@GetMapping("/")
    public String home(){
        return "Hello, Spring Boot!";
    }

}
