package jp.co.isol.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.dao.impl.AccountDaoImpl;
import jp.co.isol.common.dao.impl.HealthInfoDaoImpl;
import jp.co.isol.common.dao.impl.MailInfoDaoImpl;
import jp.co.isol.common.other.DBConnecter;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.web.session.ManageSessionManager;

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

	@Bean(name = "accountDao")
	public AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}

	@Bean(name = "healthInfoDao")
	public HealthInfoDao getHealthInfoDao() {
		return new HealthInfoDaoImpl();
	}

	@Bean(name = "mailInfoDao")
	public MailInfoDao getMailInfoDao() {
		return new MailInfoDaoImpl();
	}

}
