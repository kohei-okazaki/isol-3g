package jp.co.isol.common.web.manage;

/**
 * すべてのコントローラクラスはこのインターフェースを継承すること<br>
 *
 */
public interface BaseController {

	/**
	 * viewを返す<br>
	 * @return
	 */
	default String getView(BaseView view) {
		return view.getName();
	}
}
