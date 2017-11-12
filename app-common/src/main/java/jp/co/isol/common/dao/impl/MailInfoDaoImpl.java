package jp.co.isol.common.dao.impl;

import java.util.Date;

import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.dto.MailInfoDto;

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
		dto.setMailaddress("test-001@test.jp");
		dto.setMailPassword("password");
		dto.setRegDate(new Date());
		return null;
	}

}
