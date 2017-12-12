package jp.co.isol.common.file.excel.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * Excelヘッダのアノテーション<br>
 *
 */
@Inherited
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ExcelHeader {

	/**
	 * ヘッダ名
	 * セットした順にファイルにつめられる<br>
	 * @return ヘッダ名
	 */
	String[] names() default "";

}
