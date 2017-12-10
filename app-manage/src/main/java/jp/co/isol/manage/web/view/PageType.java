package jp.co.isol.manage.web.view;

import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * ページEnum<br>
 * 入力("0")<br>
 * 確認("1")<br>
 * 完了("2")<br>
 *
 */
public enum PageType {

	INPUT(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.INPUT)),
	CONFIRM(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.CONFIRM)),
	COMPLETE(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.COMPLETE));

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private String value;

	private PageType(String value) {
		setValue(value);
	}

}
