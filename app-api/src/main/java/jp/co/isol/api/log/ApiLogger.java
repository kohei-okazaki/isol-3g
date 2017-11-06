package jp.co.isol.api.log;

import jp.co.isol.common.log.BaseLogger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiLogger extends BaseLogger {

	private static ApiLogger instance = new ApiLogger();

	private ApiLogger() {
	}

	public static ApiLogger getInstance() {
		return instance;
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
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void debug(Class<?> clazz, String message) {
		log.debug("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void error(Class<?> clazz, String message) {
		log.error("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void warn(Class<?> clazz, String message) {
		log.warn("実行 -----> " + clazz.getSimpleName(), message);
	}

}
