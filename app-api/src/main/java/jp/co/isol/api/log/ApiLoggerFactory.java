package jp.co.isol.api.log;

import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ロガーファクトリークラス<br>
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiLoggerFactory {

	/**
	 * 指定されたクラスのログを返す<br>
	 * @param clazz
	 * @return ApiLogger
	 */
	public static ApiLogger getLogger(Class<?> clazz) {
		return new ApiLogger(LoggerFactory.getLogger(clazz));
	}

}
