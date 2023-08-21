package iot.xhl.app.controller;

import io.swagger.annotations.*;
import iot.xhl.app.domain.LiveMessage;
import iot.xhl.app.repository.LiveMsgRepository;
import iot.xhl.app.vo.LiveMsgVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "LiveMsg ES接口")
@RequestMapping("/warnMsg")
public class LiveMsgController {

	@Resource
	private LiveMsgRepository msgRepository;

	@ApiOperation(value = "保存一条 LiveMessage Doc 数据", response = LiveMessage.class)
	@PostMapping("/save")
	public Object save(@RequestBody LiveMsgVO msgVO) {
		LiveMessage message = new LiveMessage();
		BeanUtils.copyProperties(msgVO, message);
		return msgRepository.save(message);
	}

	@ApiOperation(value = "LiveMsg Doc 全量查询")
	@GetMapping("/findAll")
	public Object findAll() {
		Pageable pageable = PageRequest.of(0, 10);
		return msgRepository.findAll(pageable);
	}

	@ApiOperation(value = "根据 IP 查询")
	@GetMapping("/findAllByIp")
	public Object findAllByIp() {
		Pageable pageable = PageRequest.of(0, 10);
		return msgRepository.findBySrcIp("192.168.8.184", pageable);
	}

	@ApiOperation(value = "根据 src dst 查询")
	@GetMapping("/src/{src}/dest/{dst}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "src", value = "source IP(v4)", type = "String", required = true),
			@ApiImplicitParam(name = "dst", value = "destination IP(v4)", type = "String", required = true)
	})
	@ApiResponse(response = List.class, message = "LiveMessage分页", code = 200)
	public Object findDistinctTopBySrcIpEqualsAndDstIpEquals(@PathVariable(name = "src") String src,
	                                                         @PathVariable(name = "dst") String dst
	) {
		Pageable pageable = PageRequest.of(0, 10);
		return msgRepository.findDistinctTopBySrcIpEqualsAndDstIpEquals(src, dst, pageable);
	}
}
