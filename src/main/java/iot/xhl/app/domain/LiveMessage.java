/**
 * Copyright 2023 json.cn
 */
package iot.xhl.app.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2023-08-18 22:49:42
 *
 * @author json.cn (i@json.cn)
 * @website <a href="http://www.json.cn/java2pojo/">Json.cn</a>
 */
@Data
@Document(indexName = "iot_warn_history_message")
//@Document(indexName = "iot_warn_history_message_#{@indexNameGenerator.commonIndex()}") //动态创建索引名字
public class LiveMessage implements Serializable {

	private static final long serialVersionUID = 8498501025632950288L;

	private String _class;

	@Field(type = FieldType.Keyword)
	private String id;

	@Field(type = FieldType.Keyword)
	private String attackType;

	@Field(type = FieldType.Object)
	private List<ProbRank> probRank;

	@Field(type = FieldType.Ip)
	private String srcIp;

	@Field(type = FieldType.Ip)
	private String dstIp;

	@Field(type = FieldType.Integer)
	private int srcPort;

	@Field(type = FieldType.Integer)
	private int dstPort;

	@Field(type = FieldType.Keyword)
	private String protocol;

	@Field(type = FieldType.Long)
	private long timestamp;

	@Field(type = FieldType.Integer)
	private long microsecond;

	@Data
	public static class ProbRank {
		private String label;
		private String score;
	}
}