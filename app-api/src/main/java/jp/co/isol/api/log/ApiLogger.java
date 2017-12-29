package jp.co.isol.api.log;

import org.slf4j.Logger;

import jp.co.isol.common.log.BaseLogger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * APIロガークラス<br>
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiLogger extends BaseLogger {

	private Logger logger;

	public ApiLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * infologを出力
	 * @param clazz
	 */
	@Override
	public void info(Class<?> clazz) {
		this.info(clazz, "");
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 */
	@Override
	public void debug(Class<?> clazz) {
		this.debug(clazz, "");
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 */
	@Override
	public void error(Class<?> clazz) {
		this.error(clazz, "");
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 */
	@Override
	public void warn(Class<?> clazz) {
		this.warn(clazz, "");
	}

	/**
	 * infologを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void info(Class<?> clazz, String message) {
		logger.info("実行 -----> " + clazz.getSimpleName() + "#" + message);
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void debug(Class<?> clazz, String message) {
		logger.debug("実行 -----> " + clazz.getSimpleName() + "#" + message);
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void error(Class<?> clazz, String message) {
		logger.error("実行 -----> " + clazz.getSimpleName() + "#" + message);
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void warn(Class<?> clazz, String message) {
		logger.warn("実行 -----> " + clazz.getSimpleName() + "#" + message);
	}

}
