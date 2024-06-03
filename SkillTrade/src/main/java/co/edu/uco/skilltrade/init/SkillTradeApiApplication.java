package co.edu.uco.skilltrade.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"co.edu.uco.skilltrade"})
public class SkillTradeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillTradeApiApplication.class, args);
	}

}
