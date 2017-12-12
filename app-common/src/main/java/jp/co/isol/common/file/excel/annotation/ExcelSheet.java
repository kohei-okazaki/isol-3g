package jp.co.isol.common.file.excel.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * Excelシートのアノテーション<br>
 *
 */
@Inherited
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ExcelSheet {

	/**
	 * シート名<br>
	 * セットした順にファイルにつめられる<br>
	 * @return シート名
	 */
	String value() default "";

}
