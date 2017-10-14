package jp.co.isol.manage.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.isol.common.other.DBConnecter;
import jp.co.isol.manage.web.session.AppSessionManager;
import jp.co.isol.manage.log.AppLogger;

/**
 * @author kou1210hei<br>
 * アプリケーションコンフィグクラス<br>
 *
 */
@Configuration
public class AppConfig {

	@Bean(name = "appSessionManager")
	public AppSessionManager getAppSessionManager() {
		return new AppSessionManager();
	}

	@Bean(name = "dbConnecter")
	public DBConnecter getDBConnecter() {
		return new DBConnecter();
	}

	@Bean(name = "appLogger")
	public AppLogger getAppLogger() {
		return new AppLogger();
	}

}
