package jp.co.isol.manage.service.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 結果照会CSVダウンロードサービス実装クラスのマーカーアノテーション<br>
 *
 */
@Inherited
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD })
@Qualifier("referenceCsv")
public @interface ReferenceCsv {

}
