package iot.xhl.app.config;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component("indexNameGenerator")
public class ESIndexGenerator {

	/**
	 * 根据时间动态生成索引名
	 *
	 * @return
	 */
	public String commonIndex() {
		//根据日期生成index
		return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
	}
}
