package jp.co.isol.common.dao.impl;

import java.util.Date;

import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.entity.MailInfo;
import jp.co.isol.common.other.OSDefine;

/**
 * メール情報のDaoクラス
 *
 */
public class MailInfoDaoImpl implements MailInfoDao {

	private static final String RESOURCES = OSDefine.isWin() ? "C:\\work\\data.xlsx" : "/Applications/data.xlsx";
	private static final String SHEET = "MAIL_INFO";
	private static final int HEADER_POSITION = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MailInfo getMailInfoByUserId(String userId) {
		MailInfo mailInfo = new MailInfo();
		mailInfo.setUserId(userId);
		mailInfo.setMailAddress("test-001@test.jp");
		mailInfo.setMailPassword("password");
		mailInfo.setRegDate(new Date());
		return mailInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateMailInfo(MailInfo mailInfo) {
		// TODO 更新処理を追加すること
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registMailInfo(MailInfo mailInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
