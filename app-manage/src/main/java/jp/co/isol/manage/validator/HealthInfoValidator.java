package jp.co.isol.manage.validator;

import java.math.BigDecimal;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import jp.co.isol.common.mvc.BaseValidator;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.manage.form.HealthInfoForm;

/**
 * 健康情報Validateクラス<br>
 *
 */
public class HealthInfoValidator extends BaseValidator<HealthInfoForm> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return HealthInfoForm.class.isAssignableFrom(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Object object, Errors errors) {

		HealthInfoForm form = (HealthInfoForm) object;
		// 必須チェック
		checkRequire(errors);
		// 属性チェック
		checkType(form, errors);

	}

	/**
	 * 属性チェック
	 * @param form
	 * @param errors
	 */
	private void checkType(HealthInfoForm form, Errors errors) {

		if (!StringUtil.isHalfNumberPeriod(form.getHeight().toString())) {
			errors.rejectValue("height", "errors.halfNumberPeriod");
		}
		if (!StringUtil.isHalfNumberPeriod(form.getWeight().toString())) {
			errors.rejectValue("weight", "errors.halfNumberPeriod");
		}

		if (BigDecimal.ZERO.equals(form.getHeight())) {
			errors.rejectValue("height", "errors.zero");
		}
		if (BigDecimal.ZERO.equals(form.getWeight())) {
			errors.rejectValue("weight", "errors.zero");
		}

	}

	/**
	 * 必須チェックを行う<br>
	 * @param errors
	 */
	private void checkRequire(Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "height", "REQUIRED");
		ValidationUtils.rejectIfEmpty(errors, "weight", "REQUIRED");
	}

}
