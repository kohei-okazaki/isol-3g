package jp.co.isol.common.dao;

import jp.co.isol.common.other.OSDefine;

/**
 * dao基底インターフェース<br>
 *
 */
public interface BaseDao {

	/** 保存先ファイルパス */
	public static final String RESOURCES = OSDefine.isWin() ? "C:\\work\\data.xlsx" : "/Applications/data.xlsx";

	/** ヘッダー位置*/
	public static final int HEADER_POSITION = 0;

}
