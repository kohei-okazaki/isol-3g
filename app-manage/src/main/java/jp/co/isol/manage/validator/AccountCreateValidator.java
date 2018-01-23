package jp.co.isol.manage.validator;

import org.springframework.validation.Errors;

import jp.co.isol.common.util.ValidationUtil;
import jp.co.isol.common.web.mvc.BaseValidator;
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

	}

	/**
	 * 必須チェックを行う<br>
	 * @param errors
	 */
	private void checkRequire(Errors errors) {

		ValidationUtil.rejectIfEmpty(errors, "height");
		ValidationUtil.rejectIfEmpty(errors, "weight");
	}

}