package jp.co.isol.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.isol.api.exception.HealthInfoException;
import jp.co.isol.api.request.HealthInfoRequest;
import jp.co.isol.api.response.HealthInfoResponse;
import jp.co.isol.api.service.HealthInfoService;
import jp.co.isol.common.web.api.BaseApiRestController;

/**
 * 健康情報APIコントローラ<br>
 *
 */
@RestController
@RequestMapping(value = "/healthInfo", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class HealthInfoController extends BaseApiRestController<HealthInfoRequest, HealthInfoResponse, HealthInfoService, HealthInfoException> {

	/** 健康情報サービスクラス */
	@Autowired
	private HealthInfoService healthInfoService;
	/** 健康情報リクエストクラス */
	@Autowired
	private HealthInfoRequest healthInfoRequest;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping
	public HealthInfoResponse doGet(HttpServletRequest request) throws HealthInfoException {

		// リクエスト情報をセットする
		healthInfoRequest.setRequest(request);

		// セットされたリクエスト情報のチェック実施
		healthInfoService.checkRequest(healthInfoRequest);

		HealthInfoResponse response = healthInfoService.execute(healthInfoRequest);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	public HealthInfoResponse doPost(HttpServletRequest request) throws HealthInfoException {
		return doGet(request);
	}

}
