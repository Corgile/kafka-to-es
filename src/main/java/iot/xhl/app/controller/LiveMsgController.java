package iot.xhl.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import iot.xhl.app.domain.LiveMessage;
import iot.xhl.app.repository.LiveMsgRepository;
import iot.xhl.app.vo.LiveMsgVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
}
