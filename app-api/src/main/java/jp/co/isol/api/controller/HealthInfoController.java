package jp.co.isol.api.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.isol.api.exception.BaseApiException;
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
	/** 健康情報リクエストクラス */
	@Autowired
	private HealthInfoRequest healthInfoRequest;

	/**
	 * Getでリクエストを受け付ける
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws BaseApiException
	 */
	@GetMapping
	public HealthInfoDto get(HttpServletRequest request) throws ParseException, BaseApiException {

		// リクエスト情報をセットする
		healthInfoRequest.setRequest(request);

		// マッピングされたリクエスト情報のチェック実施
		healthInfoService.checkRequest(healthInfoRequest);

		return healthInfoService.execute(healthInfoRequest);
	}

	/**
	 * Postでリクエストを受け付ける
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws BaseApiException
	 */
	@PostMapping
	public HealthInfoDto post(HttpServletRequest request) throws ParseException, BaseApiException {
		return get(request);
	}

}
