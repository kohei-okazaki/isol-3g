package jp.co.isol.common.web.manage;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * InternalResourceViewResolverを継承したクラス<br>
 * 要修正
 *
 */
public class BaseInternalResourceViewResolver extends InternalResourceViewResolver {

	/**
	 * コンストラクタ<br>
	 */
	public BaseInternalResourceViewResolver() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> requiredViewClass() {
		return super.requiredViewClass();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlwaysInclude(boolean alwaysInclude) {
		super.setAlwaysInclude(alwaysInclude);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		return super.buildView(viewName);
	}
}