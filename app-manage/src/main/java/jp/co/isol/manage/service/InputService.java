package jp.co.isol.manage.service;

import java.math.BigDecimal;
import java.util.Objects;

import jp.co.isol.manage.form.MenuForm;


/**
 * 入力画面サービスIF
 *
 */
public interface InputService {

	/**
	 * 入力情報のチェック
	 * @param form
	 * @return 判定結果
	 */
	public boolean hasError(MenuForm form);

	/**
	 * マイナスが含まれていた場合true
	 * 引き数はnullではないものとする
	 * @param target1
	 * @param target2
	 * @return 判定結果
	 */
	public default boolean hasContainMinus(BigDecimal target1, BigDecimal target2) {
		return target1.toString().contains("-") || target2.toString().contains("-");

	}

	/**
	 * nullが含まれていた場合true
	 * @param target1
	 * @param target2
	 * @return 判定結果
	 */
	public default boolean hasNull(BigDecimal target1, BigDecimal target2) {
		return Objects.isNull(target1) || Objects.isNull(target2);
	}

}
