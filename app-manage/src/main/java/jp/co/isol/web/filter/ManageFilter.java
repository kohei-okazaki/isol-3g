package jp.co.isol.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jp.co.isol.common.web.manage.BaseFilter;
import jp.co.isol.web.config.ManageConfig;
import jp.co.isol.web.session.ManageSessionKey;
import jp.co.isol.web.session.ManageSessionManager;

/**
 * 健康情報管理画面フィルタークラス<br>
 *
 */
public class ManageFilter extends BaseFilter {

	/**
	 * 初期化処理を行う。<br>
	 * このメソッドはアプリケーション起動時に呼び出される。</br>
	 * サーブレットフィルタの初期化パラメータは引数のFilterConfigから取得できる。
	 * @param filterConfig
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
	}

	/**
	 * ここに前処理を実装する<br>
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		ManageSessionManager sessionManager;

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		String userId = (String) sessionManager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);
		String reqUri = request.getRequestURI();

		chain.doFilter(req, resp);

	}

	/**
	 * アプリケーション終了時の処理実装
	 */
	@Override
	public void destroy() {
		super.destroy();
	}

}
