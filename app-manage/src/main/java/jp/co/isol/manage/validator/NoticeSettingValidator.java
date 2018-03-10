package jp.co.isol.manage.validator;

import org.springframework.validation.Errors;

import jp.co.isol.common.web.manage.BaseValidator;
import jp.co.isol.manage.form.AccountSettingForm;
import jp.co.isol.manage.form.NoticeSettingForm;

/**
 * 通知情報設定Validateクラス<br>
 *
 */
public class NoticeSettingValidator extends BaseValidator<NoticeSettingForm> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return NoticeSettingForm.class.isAssignableFrom(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Object object, Errors errors) {

		AccountSettingForm form = (AccountSettingForm) object;

	}

}
