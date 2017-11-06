package jp.co.isol.api.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.isol.api.dto.HealthInfoDto;
import jp.co.isol.api.service.HealthInfoService;
import jp.co.isol.common.util.CalcUtil;

/**
 * @author kou1210hei<br>
 * 健康情報APIコントローラ<br>
 *
 */
@RestController
@RequestMapping(value = "/healthInfo", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class HealthInfoController {

	@Autowired
	private HealthInfoService healthInfoService;

	@GetMapping
	public HealthInfoDto get(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		BigDecimal height =  new BigDecimal(request.getParameter("height"));
		BigDecimal weight = new BigDecimal(request.getParameter("weight"));
		BigDecimal bmi = healthInfoService.calcBmi(CalcUtil.convertMeter(height), weight);
		BigDecimal standardWeight = healthInfoService.calcStandardWeight(CalcUtil.convertMeter(height));
		Date regDate = new Date();

		String message = "###get()";
		System.out.println(message);
		HealthInfoDto dto = new HealthInfoDto();
		dto.setDataId("001");
		dto.setUserId(userId);
		dto.setHeight(height);
		dto.setWeight(weight);
		dto.setBmi(bmi);
		dto.setStandardWeight(standardWeight);
		dto.setRegDate(regDate);

		return dto;
	}

	@PostMapping
	public void post(HttpServletRequest request) {
		String message = "###post()";
		System.out.println(message);
	}
}
