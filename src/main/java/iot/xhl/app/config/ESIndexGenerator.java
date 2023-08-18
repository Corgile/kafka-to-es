package iot.xhl.app.config;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author zp.wei
 * @date 2023/4/21 15:31
 */
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
