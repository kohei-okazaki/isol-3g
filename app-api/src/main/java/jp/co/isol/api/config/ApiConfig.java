package jp.co.isol.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dao.impl.HealthInfoDaoImpl;

/**
 * APIコンフィグクラス<br>
 * app-commonのクラスで使いたいBeanはここに登録する<br>
 * app-commonのクラスはservlet-context.xmlに定義できないため
 */
@Configuration
public class ApiConfig {

	/**
	 * 健康情報のDaoクラスを返す<br>
	 * @return
	 */
	@Bean
	public HealthInfoDao getHealthInfoDao() {
		return new HealthInfoDaoImpl();
	}

}
