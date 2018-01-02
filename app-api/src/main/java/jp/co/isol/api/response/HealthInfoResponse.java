package jp.co.isol.api.response;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isol.common.web.api.BaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康情報レスポンスクラス<br>
 *
 */
public class HealthInfoResponse extends BaseResponse {

	/** データID */
	@Setter
	@Getter
	private String dataId;

	/** ユーザID */
	@Setter
	@Getter
	private String userId;

	/** 身長 */
	@Setter
	@Getter
	private BigDecimal height;

	/** 体重 */
	@Setter
	@Getter
	private BigDecimal weight;

	/** BMI */
	@Setter
	@Getter
	private BigDecimal bmi;

	/** 標準体重 */
	@Setter
	@Getter
	private BigDecimal standardWeight;

	/** ユーザステータス */
	@Setter
	@Getter
	private String userStatus;

	/** 登録日時 */
	@Setter
	@Getter
	private Date regDate;

}
