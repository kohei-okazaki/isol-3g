package jp.co.isol.manage.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.isol.manage.web.session.AppSessionManager;

@Configuration
public class AppConfig {

	@Bean(name = "appSessionManager")
	public AppSessionManager getAppSessionManager() {
		return new AppSessionManager();
	}
}
