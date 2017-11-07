package jp.co.isol.manage.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jp.co.isol.common.web.filter.BaseFilter;
import jp.co.isol.manage.web.config.AppConfig;
import jp.co.isol.manage.web.session.AppSessionKey;
import jp.co.isol.manage.web.session.AppSessionManager;


/**
 * フィルタークラス<br>
 *
 */
@WebFilter
public class AppFilter extends BaseFilter {

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
		System.out.println(request.getRequestURI() + " : " + new Date());

		HttpSession session = request.getSession();
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppSessionManager sessionManager = context.getBean("appSessionManager", AppSessionManager.class);
		String session_id = sessionManager.getAttribute(session, AppSessionKey.USER_ID);

		System.out.println("session_id = " + session_id);
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
