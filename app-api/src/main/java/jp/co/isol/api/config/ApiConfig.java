package jp.co.isol.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dao.impl.HealthInfoDaoImpl;

/**
 * APIコンフィグクラス<br>
 *
 */
@Configuration
public class ApiConfig {

	@Bean
	public HealthInfoDao getHealthInfoDao() {
		return new HealthInfoDaoImpl();
	}

}
