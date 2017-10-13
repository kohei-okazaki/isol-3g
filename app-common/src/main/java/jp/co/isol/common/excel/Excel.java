package jp.co.isol.common.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jp.co.isol.common.message.Message;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE} )
public @interface Excel {

	/**
	 * シート名
	 * @return シート名
	 */
	String sheetName();

	/**
	 * ヘッダ名
	 * @return ヘッダ名
	 */
	Message[] headerNames();
}
