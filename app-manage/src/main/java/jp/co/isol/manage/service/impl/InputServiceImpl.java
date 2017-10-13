package jp.co.isol.manage.service.impl;

import org.springframework.stereotype.Service;

import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.service.InputService;

/**
 * @author kou1210hei<br>
 * 入力画面サービス実装クラス
 *
 */
@Service
public class InputServiceImpl implements InputService {

	/**
	 * 入力情報のチェック
	 * @param form
	 * @return 判定結果
	 */
	@Override
	public boolean hasError(MenuForm form) {

		if (hasNull(form.getWeight(), form.getHeight())) {
			return true;
		} else if (form.getWeight().doubleValue() == 0 || form.getHeight().doubleValue() == 0) {
			return true;
		} else if (hasContainMinus(form.getWeight(), form.getHeight())) {
			return true;
		}
		return false;
	}
}
