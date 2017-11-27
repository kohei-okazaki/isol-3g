package jp.co.isol.manage.view;

import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * ページEnum
 *
 */
public enum PageView {

	INPUT(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.INPUT)),
	CONFIRM(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.CONFIRM)),
	COMPLETE(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.COMPLETE));

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String value;

	private PageView(String value) {
		setValue(value);
	}

}
