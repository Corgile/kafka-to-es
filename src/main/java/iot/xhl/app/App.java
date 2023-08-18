package iot.xhl.app;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableKnife4j
@EnableSwagger2
@EnableScheduling
@EnableWebMvc
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
