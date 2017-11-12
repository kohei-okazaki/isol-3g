package jp.co.isol.manage.web.config;

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
 *
 */
@Configuration
public class ManageConfig {

	@Bean(name = "appSessionManager")
	public ManageSessionManager getAppSessionManager() {
		return new ManageSessionManager();
	}

	@Bean(name = "dbConnecter")
	public DBConnecter getDBConnecter() {
		return new DBConnecter();
	}

	@Bean(name = "appLogger")
	public ManageLogger getAppLogger() {
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
