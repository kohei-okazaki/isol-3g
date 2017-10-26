package jp.co.isol.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.dao.LoginUserDao;
import jp.co.isol.manage.dto.LoginUserDto;
import jp.co.isol.manage.service.LoginUserSearchService;

@Service
public class LoginUserSearchServiceImpl implements LoginUserSearchService {

	@Autowired
	private LoginUserDao loginUserDao;

	/**
	 * IDからログイン情報を取得する
	 * @param id
	 * @return ログイン情報
	 */
	@Override
	public LoginUserDto findLoginUserEntity(String userId) {
		return loginUserDao.getLoginUserInfoByUserId(userId);
	}

}
