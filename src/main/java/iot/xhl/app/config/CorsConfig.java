package iot.xhl.app.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedOrigins("http://192.168.1.4", "http://localhost:63342")
				.allowedOriginPatterns("192.168.0.0/24", "172.22.0.0/24")
				.allowedMethods("PUT", "GET", "POST", "DELETE")
				.allowedHeaders("*")
				.exposedHeaders("*");
	}
}
