package jp.co.isol.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.isol.api.dto.HealthInfoDto;
import jp.co.isol.api.service.HealthInfoService;

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

		HealthInfoDto dto = new HealthInfoDto();
		healthInfoService.execute(dto, request);

		return dto;
	}

	@PostMapping
	public void post(HttpServletRequest request) {
		String message = "###post()";
		System.out.println(message);
	}
}