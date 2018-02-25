package jp.co.isol.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class HealthInfoController implements BaseApiRestController<HealthInfoRequest, HealthInfoResponse, HealthInfoService, HealthInfoException> {

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
	public HealthInfoResponse execute(HttpServletRequest request) throws HealthInfoException {

		// リクエスト情報をセットする
		healthInfoRequest.setRequest(request);

		// リクエスト情報のチェック実施
		healthInfoService.checkRequest(healthInfoRequest);

		HealthInfoResponse response = healthInfoService.execute(healthInfoRequest);

		return response;
	}

}
