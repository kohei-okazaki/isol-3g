package jp.co.isol.common.file.csv.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * CSVモデルのマーカーアノテーション<br>
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface CsvModel {

}
