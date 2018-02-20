package jp.co.isol.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.dao.impl.AccountDaoImpl;
import jp.co.isol.common.dao.impl.HealthInfoDaoImpl;
import jp.co.isol.common.dao.impl.MailInfoDaoImpl;

/**
 * 管理画面Daoコンフィグクラス<br>
 * app-commonのクラスで使いたいDaoのBeanはここに登録する<br>
 * app-commonのクラスはservlet-context.xmlに定義できないため
 */
@Configuration
public class ManageDaoConfig {

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
