package jp.co.isol.manage.validator;

import org.springframework.validation.Errors;

import jp.co.isol.common.util.ValidationUtil;
import jp.co.isol.common.web.manage.BaseValidator;
import jp.co.isol.manage.form.AccountCreateForm;

/**
 * アカウント作成Validateクラス
 *
 */
public class AccountCreateValidator extends BaseValidator<AccountCreateForm> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountCreateForm.class.isAssignableFrom(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Object object, Errors errors) {

		AccountCreateForm form = (AccountCreateForm) object;

		// 必須チェックを行う
		checkRequire(errors);
		// 最大桁数チェック
		checkMaxLength(errors, form);

	}

	/**
	 * 必須チェックを行う<br>
	 * @param errors
	 */
	private void checkRequire(Errors errors) {

		ValidationUtil.rejectIfEmpty(errors, "height");
		ValidationUtil.rejectIfEmpty(errors, "weight");
	}

	/**
	 * 桁数超過チェックを行う<br>
	 * @param errors
	 * @param form
	 */
	private void checkMaxLength(Errors errors, AccountCreateForm form) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
