package jp.co.isol.manage.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import jp.co.isol.common.mvc.BaseValidator;
import jp.co.isol.manage.form.LoginForm;

/**
 * LoginフォームのValidator
 *
 */
public class LoginFormValidator extends BaseValidator<LoginForm> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.isAssignableFrom(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Object object, Errors errors) {

		LoginForm form = (LoginForm) object;
		// 必須チェック
		checkRequire(errors);
		// 桁数チェック
		checkLength(form, errors);

	}

	/**
	 * 桁数チェックを行う<br>
	 * @param form
	 * @param errors
	 */
	private void checkLength(LoginForm form, Errors errors) {

		if (!(2 < form.getUserId().length() && form.getUserId().length() <= 10)) {
			ValidationUtils.rejectIfEmpty(errors, "userId", "UUU");
		}

	}

	/**
	 * 必須チェックを行う<br>
	 * @param form
	 * @param errors
	 */
	private void checkRequire(Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "userId", "REQUIRED");
		ValidationUtils.rejectIfEmpty(errors, "password", "REQUIRED");
	}

}
