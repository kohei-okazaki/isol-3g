package jp.co.isol.api.service;

import javax.servlet.http.HttpServletRequest;

import jp.co.isol.common.dto.HealthInfoDto;


/**
 * @author kou1210hei<br>
 * 健康情報サービスIF<br>
 *
 */
public interface HealthInfoService {

	/**
	 * メイン処理<br>
	 * @param request
	 * @return 健康情報Dto
	 */
	public HealthInfoDto execute(HttpServletRequest request);

}
