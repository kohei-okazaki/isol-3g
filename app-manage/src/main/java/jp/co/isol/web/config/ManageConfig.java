package jp.co.isol.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.isol.common.other.DBConnecter;
import jp.co.isol.web.log.ManageLogger;
import jp.co.isol.web.web.session.ManageSessionManager;

/**
 * 管理画面コンフィグクラス<br>
 * app-commonのクラスで使いたいBeanはここに登録する<br>
 * app-commonのクラスはservlet-context.xmlに定義できないため
 */
@Configuration
public class ManageConfig {

	@Bean(name = "manageSessionManager")
	public ManageSessionManager getAppSessionManager() {
		return new ManageSessionManager();
	}

	@Bean(name = "dbConnecter")
	public DBConnecter getDBConnecter() {
		return new DBConnecter();
	}

	@Bean(name = "manageLogger")
	public ManageLogger getManageLogger() {
		return new ManageLogger();
	}

}
