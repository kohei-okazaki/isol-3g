package jp.co.isol.api.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.isol.common.log.BaseLogger;

/**
 * APIロガークラス<br>
 *
 */
public class ApiLogger extends BaseLogger {

	/** singleton */
	private static ApiLogger instance = new ApiLogger();

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * プライベートコンストラクタ<br>
	 * インスタンス生成を制限する<br>
	 */
	private ApiLogger() {
	}

	/**
	 * インスタンスを返す<br>
	 * @return ApiLogger
	 */
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
		LOG.info("実行 -----> " + clazz.getSimpleName() + " " + message);
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void debug(Class<?> clazz, String message) {
		LOG.debug("実行 -----> " + clazz.getSimpleName() + " " + message);
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void error(Class<?> clazz, String message) {
		LOG.error("実行 -----> " + clazz.getSimpleName() + " " + message);
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void warn(Class<?> clazz, String message) {
		LOG.warn("実行 -----> " + clazz.getSimpleName() + " " + message);
	}

}
