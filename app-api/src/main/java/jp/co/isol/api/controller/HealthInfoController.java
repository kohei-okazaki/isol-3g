package jp.co.isol.api.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.isol.api.exception.impl.HealthInfoException;
import jp.co.isol.api.request.impl.HealthInfoRequest;
import jp.co.isol.api.service.HealthInfoService;
import jp.co.isol.common.dto.HealthInfoDto;

/**
 * 健康情報APIコントローラ<br>
 *
 */
@RestController
@RequestMapping(value = "/healthInfo", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class HealthInfoController {

	/** 健康情報サービスクラス */
	@Autowired
	private HealthInfoService healthInfoService;

	/**
	 * Getでリクエストを受け付ける
	 * @param req
	 * @return
	 * @throws ParseException
	 * @throws HealthInfoException
	 */
	@GetMapping
	public HealthInfoDto get(HttpServletRequest req) throws ParseException, HealthInfoException {

		HealthInfoRequest request = new HealthInfoRequest(req);

		// マッピングされたリクエスト情報のチェック実施
		request.checkRequest();

		return healthInfoService.execute(request);
	}

}
