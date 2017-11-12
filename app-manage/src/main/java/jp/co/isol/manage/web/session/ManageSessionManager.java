package jp.co.isol.manage.web.session;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import jp.co.isol.common.util.StringUtil;

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
	public void setAttribute(HttpSession session, ManageSessionKey key, String value) {
		session.setAttribute(key.getName(), value);
	}

	/**
	 * sessionから指定されたキーに対応するvalueを返す<br>
	 * valueがnullの場合、"null"を返す
	 * @param session
	 * @param key
	 * @return value
	 */
	public String getAttribute(HttpSession session, ManageSessionKey key) {

		Object value = session.getAttribute(key.getName());
		return Objects.isNull(value) ? StringUtil.EMPTY : value.toString();
	}

	/**
	 * sessionからキーに対応するレコードを削除する<br>
	 * @param session
	 * @param key
	 */
	public void removeKey(HttpSession session, ManageSessionKey key) {
		session.removeAttribute(key.getName());
	}

}
