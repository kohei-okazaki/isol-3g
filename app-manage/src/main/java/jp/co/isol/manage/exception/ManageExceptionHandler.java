package jp.co.isol.manage.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import jp.co.isol.common.exception.BaseExceptionHandler;

/**
 * 管理画面例外ハンドラークラス<br>
 *
 */
public class ManageExceptionHandler implements BaseExceptionHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(ERROR_JSP);

		return modelView;
	}

}
