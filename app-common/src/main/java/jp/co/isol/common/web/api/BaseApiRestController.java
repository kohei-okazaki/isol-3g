package jp.co.isol.common.web.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
public abstract class BaseApiRestController<Rq extends BaseRequest
										, Rs extends BaseResponse
										, S extends BaseApiService<Rq, Rs, E>
										, E extends BaseApiException> {

	/**
	 * getでの通信の処理を行う<br>
	 * @param request
	 * @return
	 * @throws E
	 */
	@GetMapping
	Rs doGet(HttpServletRequest request) throws E {
		return this.execute(request);
	}

	/**
	 * postでの通信の処理を行う<br>
	 * @param request
	 * @return
	 * @throws E
	 */
	@PostMapping
	Rs doPost(HttpServletRequest request) throws E {
		return this.execute(request);
	}

	/**
	 * 継承先のコントローラクラスで処理する<br>
	 * @param request
	 * @return
	 * @throws E
	 */
	protected abstract Rs execute(HttpServletRequest request) throws E;

}
