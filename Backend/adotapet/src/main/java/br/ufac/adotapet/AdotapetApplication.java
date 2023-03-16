package br.ufac.adotapet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class AdotapetApplication {
	
	@RequestMapping("/")
	@ResponseBody
	public String myApplication() {
		return "Adota Pet is running!";
	}
	public static void main(String[] args) {
		SpringApplication.run(AdotapetApplication.class, args);
	}

}
