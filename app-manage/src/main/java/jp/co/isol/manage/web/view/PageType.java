package jp.co.isol.manage.web.view;

import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;

/**
 * ページ種別定義<br>
 * 入力("0")<br>
 * 確認("1")<br>
 * 完了("2")<br>
 *
 */
public enum PageType {

	/** 入力 */
	INPUT(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.INPUT)),
	/** 確認 */
	CONFIRM(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.CONFIRM)),
	/** 完了 */
	COMPLETE(CodeManager.getInstance().getValue(MainKey.PAGE_VIEW, SubKey.COMPLETE));

	/** ページ種別名 */
	private String name;

	/**
	 * コンストラクタ<br>
	 * @param name
	 */
	private PageType(String name) {
		this.name = name;
	}

	/**
	 * ページ種別名を返す<br>
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
