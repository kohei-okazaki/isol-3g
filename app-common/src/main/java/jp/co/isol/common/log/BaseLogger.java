package jp.co.isol.common.log;

/**
 * アプリ内の基底ログクラス<br>
 *
 */
public abstract class BaseLogger {

	protected abstract void info(Class<?> clazz);

	protected abstract void debug(Class<?> clazz);

	protected abstract void error(Class<?> clazz);

	protected abstract void warn(Class<?> clazz);

	protected abstract void info(Class<?> clazz, String message);

	protected abstract void debug(Class<?> clazz, String message);

	protected abstract void error(Class<?> clazz, String message);

	protected abstract void warn(Class<?> clazz, String message);

}