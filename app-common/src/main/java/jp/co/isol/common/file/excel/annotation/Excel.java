package jp.co.isol.common.file.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excelアノテーション<br>
 * <pre>
 * sheetNameでシート名を設定
 * headerNamesでヘッダー名を設定
 * </pre>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface Excel {

	/**
	 * シート名
	 * @return シート名
	 */
	String sheetName() default "";

	/**
	 * ヘッダ名
	 * @return ヘッダ名
	 */
	String[] headerNames() default "";
}
