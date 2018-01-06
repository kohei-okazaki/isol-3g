package jp.co.isol.api.log;

import org.slf4j.LoggerFactory;

/**
 * ロガーファクトリークラス<br>
 *
 */
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
