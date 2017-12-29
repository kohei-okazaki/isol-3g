package jp.co.isol.common.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 基底Validator<br>
 * すべてのvalidatorはこの抽象クラスを継承すること<br>
 *
 */
public abstract class BaseValidator<F extends BaseForm> implements Validator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean supports(Class<?> clazz);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void validate(Object target, Errors errors);

}