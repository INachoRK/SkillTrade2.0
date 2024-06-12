package co.edu.uco.skilltrade.init;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "co.edu.uco.skilltrade")
public class SkillTradeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillTradeApiApplication.class, args);
	}

}
