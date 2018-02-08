package jp.co.isol.common.dao.impl;

import java.util.Date;

import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.dto.MailInfoDto;

/**
 * メール情報のDaoクラス
 *
 */
public class MailInfoDaoImpl implements MailInfoDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MailInfoDto getMailInfoByUserId(String userId) {
		MailInfoDto dto = new MailInfoDto();
		dto.setUserId(userId);
		dto.setMailAddress("test-001@test.jp");
		dto.setMailPassword("password");
		dto.setRegDate(new Date());
		return dto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateMailInfo(MailInfoDto mailInfoDto) {
		// TODO 更新処理を追加すること
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registMailInfo(MailInfoDto mailInfoDto) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
