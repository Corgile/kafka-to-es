package iot.xhl.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanInjection {

	@Bean(name = {"objectMapper"})
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
