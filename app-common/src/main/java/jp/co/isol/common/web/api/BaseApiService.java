package jp.co.isol.common.web.api;

import jp.co.isol.common.exception.BaseApiException;

/**
 * API基底サービス<br>
 * 各機能のサービスの親クラスとする<br>
 * @param <Rq> リクエスト種別
 * @param <Rs> レスポンス種別
 * @param <E> 例外種別
 */
public interface BaseApiService<Rq extends BaseRequest, Rs extends BaseResponse, E extends BaseApiException> {

	/**
	 * 継承先でそれぞれチェックを実装<br
	 * @param Rq Request実装クラス
	 * @throws E 例外実装クラス
	 */
	public void checkRequest(Rq request) throws E;

	/**
	 * メイン処理<br>
	 * @param Rq Request実装クラス
	 * @return Rs Response実装クラス
	 * @throws E
	 */
	public Rs execute(Rq request) throws E;

}
