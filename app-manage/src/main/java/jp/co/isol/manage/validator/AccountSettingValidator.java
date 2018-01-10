package jp.co.isol.manage.validator;

import org.springframework.validation.Errors;

import jp.co.isol.common.web.mvc.BaseValidator;
import jp.co.isol.manage.form.AccountSettingForm;

/**
 * アカウント設定Validateクラス<br>
 *
 */
public class AccountSettingValidator extends BaseValidator<AccountSettingForm> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountSettingForm.class.isAssignableFrom(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Object target, Errors errors) {

		AccountSettingForm form = (AccountSettingForm) target;

	}

}
