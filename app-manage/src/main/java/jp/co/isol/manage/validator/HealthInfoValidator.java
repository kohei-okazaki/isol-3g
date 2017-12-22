package jp.co.isol.manage.validator;

import org.springframework.validation.Errors;

import jp.co.isol.common.mvc.BaseValidator;
import jp.co.isol.manage.form.HealthInfoForm;

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
	public void validate(Object target, Errors errors) {


	}

}
