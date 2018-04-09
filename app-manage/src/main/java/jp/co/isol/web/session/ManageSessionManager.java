package jp.co.isol.web.session;

import javax.servlet.http.HttpSession;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * 管理画面内のsession管理クラス
 *
 */
public class ManageSessionManager {

	/**
	 * sessionにセットする<br>
	 * @param session
	 * @param key
	 * @param value
	 */
	public void setAttribute(HttpSession session, @NonNull ManageSessionKey key, @Nullable Object value) {
		session.setAttribute(key.getName(), value);
	}

	/**
	 * sessionから指定されたキーに対応するvalueを返す<br>
	 * valueがnullの場合、"空文字"を返す
	 * @param session
	 * @param key
	 * @return value
	 */
	public Object getAttribute(HttpSession session, @NonNull ManageSessionKey key) {
		return session.getAttribute(key.getName());
	}

	/**
	 * sessionからキーに対応するレコードを削除する<br>
	 * @param session
	 * @param key
	 */
	public void removeKey(HttpSession session, @NonNull ManageSessionKey key) {
		session.removeAttribute(key.getName());
	}

}
