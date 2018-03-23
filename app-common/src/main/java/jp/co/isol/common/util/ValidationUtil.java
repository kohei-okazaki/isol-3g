package jp.co.isol.common.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import jp.co.isol.common.exception.ErrorCode;

/**
 * validatenのUtilクラス<br>
 *
 */
public class ValidationUtil {

	/**
	 * プライベートコンストラクタ<br>
	 * インスタンスの生成を制限<br>
	 */
	private ValidationUtil() {
	}

	/**
	 * fieldのformの値が空文字の場合、errorsオブジェクトにエラーを追加する<br>
	 * @param errors
	 * @param field
	 */
	public static void rejectIfEmpty(Errors errors, String field) {
		ValidationUtils.rejectIfEmpty(errors, field, ErrorCode.REQUIRE.getErrorCode());
	}

	/**
	 * fieldのformの値がmaxを超過してる場合、errorsオブジェクトにエラーを追加する<br>
	 * @param errors
	 * @param field
	 * @param max
	 */
	public static void rejectIfLengthMax(Errors errors, String field, int max) {
		String fieldValue = errors.getFieldValue(field).toString();
		if (max < fieldValue.length()) {
			errors.rejectValue(fieldValue, ErrorCode.LENGTH.getErrorCode());
		}
	}

	/**
	 * fieldのformの値がmin未満の場合、errorsオブジェクトにエラーを追加する<br>
	 * @param errors
	 * @param field
	 * @param min
	 */
	public static void rejectIfLengthMin(Errors errors, String field, int min) {
		String fieldValue = errors.getFieldValue(field).toString();
		if (fieldValue.length() < min) {
			errors.rejectValue(fieldValue, ErrorCode.LENGTH.getErrorCode());
		}
	}

	/**
	 * fieldValueが半角数字-ピリオドでない場合、errorsオブジェクトにエラーを追加する<br>
	 * @param errors
	 * @param field
	 */
	public static void rejectIfNotHalfNumberPeriod(Errors errors, String field) {
		String fieldValue = errors.getFieldValue(field).toString();
		if (!StringUtil.isHalfNumberPeriod(fieldValue)) {
			errors.rejectValue(field, "errors.halfNumberPeriod");
		}
	}


}
