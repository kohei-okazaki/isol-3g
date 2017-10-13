package jp.co.isol.manage.web.session;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import jp.co.isol.common.util.StringUtil;

/**
 * @author kohei.okazaki<br>
 * App内のsession管理クラス
 *
 */
public class AppSessionManager {

	private static AppSessionManager instance = new AppSessionManager();

	public static AppSessionManager getInstance() {
		return instance;
	}

	/**
	 * sessionにセットする<br>
	 * @param session
	 * @param key
	 * @param value
	 */
	public void setAttribute(HttpSession session, AppSessionKey key, String value) {
		session.setAttribute(key.getName(), value);
	}

	/**
	 * sessionから指定されたキーに対応するvalueを返す<br>
	 * valueがnullの場合、"null"を返す
	 * @param session
	 * @param key
	 * @return value
	 */
	public String getValue(HttpSession session, AppSessionKey key) {

		Object value = session.getAttribute(key.getName());
		return Objects.isNull(value) ? StringUtil.TEMP : value.toString();
	}

	/**
	 * sessionからキーに対応するレコードを削除する<br>
	 * @param session
	 * @param key
	 */
	public void removeKey(HttpSession session, AppSessionKey key) {
		session.removeAttribute(key.getName());
	}

}
