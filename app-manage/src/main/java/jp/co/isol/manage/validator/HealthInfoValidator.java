package jp.co.isol.manage.validator;

import java.math.BigDecimal;

import org.springframework.validation.Errors;

import jp.co.isol.common.util.ValidationUtil;
import jp.co.isol.common.web.manage.BaseValidator;
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

		// 半角数字-ピリオドかどうか確認
		ValidationUtil.rejectIfNotHalfNumberPeriod(errors, "height");
		ValidationUtil.rejectIfNotHalfNumberPeriod(errors, "weight");

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

		ValidationUtil.rejectIfEmpty(errors, "height");
		ValidationUtil.rejectIfEmpty(errors, "weight");
	}

}
