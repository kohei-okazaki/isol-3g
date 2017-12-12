package jp.co.isol.common.file.excel.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Excelモデルのマーカーアノテーション<br>
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ExcelModel {

}
