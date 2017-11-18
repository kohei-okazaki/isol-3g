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
	 * 引数で指定されたユーザIDのメール情報を取得する
	 * @param userId
	 * @return AccountDto
	 */
	@Override
	public MailInfoDto getAccountByUserId(String userId) {
		MailInfoDto dto = new MailInfoDto();
		dto.setUserId(userId);
		dto.setMailAddress("test-001@test.jp");
		dto.setMailPassword("password");
		dto.setRegDate(new Date());
		return dto;
	}

	/**
	 * 引数で指定されたメール情報を更新する
	 * @param mailInfoDto
	 */
	@Override
	public void updateAccount(MailInfoDto mailInfoDto) {
		// TODO 更新処理を追加すること
	}

}
