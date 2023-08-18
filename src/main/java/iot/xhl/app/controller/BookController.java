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

/**
 * @author zp.wei
 * {@code @date} 2021/6/28 15:39
 */

@RestController
@Api(tags = "BOOK 接口")
@RequestMapping("/book")
public class BookController {

	@Resource
	private LiveMsgRepository msgRepository;

	@ApiOperation(value = "保存一条 LiveMessage Doc 数据")
	@PostMapping("/save")
	public Object save(@RequestBody LiveMsgVO msgVO) {
		LiveMessage message = new LiveMessage();
		BeanUtils.copyProperties(msgVO, message);
		return msgRepository.save(message);
	}

	@ApiOperation(value = "BOOK Doc 全量查询")
	@GetMapping("/findAll")
	public Object findAll() {
		Pageable pageable = PageRequest.of(0, 10);
		return msgRepository.findAll(pageable);
	}
}
