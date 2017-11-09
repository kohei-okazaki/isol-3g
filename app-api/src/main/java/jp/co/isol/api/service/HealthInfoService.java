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
	 * 健康情報DTOにrequestの内容をつめる<br>
	 * @param dto
	 * @param request
	 */
	public HealthInfoDto execute(HttpServletRequest request);

}
