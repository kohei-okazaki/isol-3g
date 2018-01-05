package jp.co.isol.common.web.api;

import javax.servlet.http.HttpServletRequest;

import jp.co.isol.common.exception.BaseApiException;

/**
 * RestAPI基底コントローラ<br>
 * すべてのRestAPIコントローラはこのクラスを継承すること<br>
 *
 * @param <Rq> リクエストクラス
 * @param <Rs> レスポンスクラス
 * @param <S> サービスクラス
 * @param <E> 例外クラス
 */
public abstract class BaseApiRestController<Rq extends BaseRequest, Rs extends BaseResponse, S extends BaseApiService<Rq, Rs, E>, E extends BaseApiException> {

	/**
	 * getでの通信の処理を行う<br>
	 * @param request
	 * @return
	 * @throws E
	 */
	protected abstract Rs doGet(HttpServletRequest request) throws E;

	/**
	 * postでの通信の処理を行う<br>
	 * @param request
	 * @return
	 * @throws E
	 */
	protected abstract Rs doPost(HttpServletRequest request) throws E;
}
