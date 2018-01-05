package jp.co.isol.common.web.api;

import lombok.Getter;
import lombok.Setter;

/**
 * APIの基底レスポンスクラス<br>
 *
 */
public abstract class BaseResponse {

	/** 結果 */
	@Setter
	@Getter
	private int result;

}
