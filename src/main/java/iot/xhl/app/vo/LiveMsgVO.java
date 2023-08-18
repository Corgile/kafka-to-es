package iot.xhl.app.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LiveMsgVO implements Serializable {
	private static final long serialVersionUID = 8498501025632950288L;

	private String attackType;

	private String srcIp;

	private String dstIp;

	private int srcPort;

	private int dstPort;

	private String protocol;

	private long timestamp;

	private long microsecond;

}
