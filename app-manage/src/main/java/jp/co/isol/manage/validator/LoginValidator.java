package jp.co.isol.manage.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import jp.co.isol.common.exception.ErrorCodeDefine;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.common.web.mvc.BaseValidator;
import jp.co.isol.manage.form.LoginForm;

/**
 * ログイン画面のValidateクラス<br>
 *
 */
public class LoginValidator extends BaseValidator<LoginForm> {

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
		// 属性チェック
		checkType(form, errors);

	}

	/**
	 * 属性チェックを行う<br>
	 * @param form
	 * @param errors
	 */
	private void checkType(LoginForm form, Errors errors) {

		if (!StringUtil.isHalfChar(form.getUserId()) || !StringUtil.isHalfChar(form.getPassword())) {
			// 半角英数字であるない場合
			errors.rejectValue("userId", ErrorCodeDefine.TYPE.toString());
		}

	}

	/**
	 * 桁数チェックを行う<br>
	 * @param form
	 * @param errors
	 */
	private void checkLength(LoginForm form, Errors errors) {

		if (!(2 < form.getUserId().length() && form.getUserId().length() <= 10)) {
			ValidationUtils.rejectIfEmpty(errors, "userId", ErrorCodeDefine.LENGTH.toString());
		}

	}

	/**
	 * 必須チェックを行う<br>
	 * @param errors
	 */
	private void checkRequire(Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "userId", ErrorCodeDefine.REQUIRE.toString());
		ValidationUtils.rejectIfEmpty(errors, "password", ErrorCodeDefine.REQUIRE.toString());
	}

}
