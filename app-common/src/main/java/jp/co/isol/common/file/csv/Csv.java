package jp.co.isol.common.file.csv;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Csvアノテーション<br>
 * headerNamesでヘッダー名を設定<br>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface Csv {

	/**
	 * ヘッダ名
	 * @return ヘッダ名
	 */
	String[] headerNames() default "";
}
