package iot.xhl.app.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LiveMsgVO implements Serializable {
	private static final long serialVersionUID = 8498501025632950288L;
	@ApiModelProperty(notes = "攻击类型", allowableValues = "见文档")
	private String attackType;
	@ApiModelProperty(notes = "Source IP", allowableValues = "IPv4地址")
	private String srcIp;
	@ApiModelProperty(notes = "Destination IP", allowableValues = "IPv4地址")
	private String dstIp;
	@ApiModelProperty(notes = "Source Port", allowableValues = "range(0, 65535]")
	private int srcPort;
	@ApiModelProperty(notes = "Destination Port", allowableValues = "range(0, 65535]")
	private int dstPort;
	@ApiModelProperty(notes = "传输层协议", allowableValues = "TCP，UDP")
	private String protocol;
	@ApiModelProperty(notes = "unix时间戳(秒)", allowableValues = "10位整数")
	private long timestamp;
	@ApiModelProperty(notes = "unix时间戳(微秒)", allowableValues = "6位整数")
	private long microsecond;
}
